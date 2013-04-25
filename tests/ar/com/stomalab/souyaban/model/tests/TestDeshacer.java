package ar.com.stomalab.souyaban.model.tests;

import junit.framework.TestCase;

import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.JugadorAutomatico;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;

public class TestDeshacer extends TestCase {

	Escenario escenario;
	
	public void setUp(){
		// #######
	    // #  .. #
	    // #   @ #
	    // #   $ #
	    // # $   #
	    // #######
		
		this.escenario = new Escenario();
		this.escenario.agregarPared(new Pared(1,1));
		this.escenario.agregarPared(new Pared(2,1));
		this.escenario.agregarPared(new Pared(3,1));
		this.escenario.agregarPared(new Pared(4,1));
		this.escenario.agregarPared(new Pared(5,1));
		this.escenario.agregarPared(new Pared(6,1));
		this.escenario.agregarPared(new Pared(7,1));
		
		this.escenario.agregarPared(new Pared(1,2));
		this.escenario.agregarDestino(new Destino(4,2));
		this.escenario.agregarDestino(new Destino(5,2));
		this.escenario.agregarPared(new Pared(7,2));
		
		this.escenario.agregarPared(new Pared(1,3));
		Persona persona = new Persona(5, 3);
		persona.setEscenario(this.escenario);
		this.escenario.agregarPersona(persona);
		this.escenario.agregarPared(new Pared(7,3));
		
		this.escenario.agregarPared(new Pared(1,4));
		Caja caja1 = new Caja(5, 4);
		caja1.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja1);
		this.escenario.agregarPared(new Pared(7,4));
		
		this.escenario.agregarPared(new Pared(1,5));
		Caja caja2 = new Caja(3, 5);
		caja2.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja2);
		this.escenario.agregarPared(new Pared(7,5));
		
		this.escenario.agregarPared(new Pared(1,6));
		this.escenario.agregarPared(new Pared(2,6));
		this.escenario.agregarPared(new Pared(3,6));
		this.escenario.agregarPared(new Pared(4,6));
		this.escenario.agregarPared(new Pared(5,6));
		this.escenario.agregarPared(new Pared(6,6));
		this.escenario.agregarPared(new Pared(7,6));
	}
	
	@Test
	public void test12A01DeshacerSimpleVolverAOriginal(){
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		int x_inicial = this.escenario.getPersona().getX();
		int y_inicial = this.escenario.getPersona().getY();
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		for (int i = 0; i < instrucciones.length(); i++){
			this.escenario.deshacer();
		}
		
		int x_final = this.escenario.getPersona().getX();
		int y_final = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en la misma pos_x", x_inicial, x_final);
		assertEquals("El jugador deberia haber quedado en la misma pos_y", y_inicial, y_final);
	}
	
	@Test
	public void test12A02DeshacerSimpleVariosUndos(){
		// Mover por zona libre (7 movimientos), 1 undo, 3 undos
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		int x_esperado = 3;
		int y_esperado = 3;
		
		int x = this.escenario.getPersona().getX();
		int y = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado, x);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado, y);
		
		for (int i = 0; i < 3; i++){
			this.escenario.deshacer();
		}
		
		x_esperado = 5;
		y_esperado = 2;

		x = this.escenario.getPersona().getX();
		y = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado, x);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado, y);
		
	}
	
	@Test
	public void test12A03DeshacerMasUndosQueMovimientos(){
		// Mover por zona libre (7 movimientos), 1 undo, 3 undos
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		int x_inicial = this.escenario.getPersona().getX();
		int y_inicial = this.escenario.getPersona().getY();
		
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		for (int i = 0; i < instrucciones.length() + 5; i++){
			this.escenario.deshacer();
		}		
		
		int x_final = this.escenario.getPersona().getX();
		int y_final = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en la misma pos_x", x_inicial, x_final);
		assertEquals("El jugador deberia haber quedado en la misma pos_y", y_inicial, y_final);
	}
	
	@Test
	public void test12A04DeshacerZonasTrabadasNoCuentan(){
		// Mover por zonas libres y trabadas, mover en zona trabada no cuenta para undo.
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RUUUUUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		int x_esperado = 6;
		int y_esperado = 3;
		
		int x = this.escenario.getPersona().getX();
		int y = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado, x);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado, y);
		
		
		instrucciones = "DDDDDDDDDDDLLUUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);

		this.escenario.deshacer();
		
		x_esperado = 4;
		y_esperado = 3;
		
		x = this.escenario.getPersona().getX();
		y = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado, x);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado, y);
		
		for (int i = 0; i < 5; i++){
			this.escenario.deshacer();
		}

		x_esperado = 6;
		y_esperado = 4;

		x = this.escenario.getPersona().getX();
		y = this.escenario.getPersona().getY();

		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado, x);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado, y);		
	}
	
	@Test
	public void test12A05DeshacerCajasYZonasTrabadasNoCuentan(){
		// Mover por zonas libres y trabadas, mover en zona trabada no cuenta para undo.
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RUUUUUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		int x_esperado = 6;
		int y_esperado = 3;
		
		int x = this.escenario.getPersona().getX();
		int y = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado, x);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado, y);
		
		
		instrucciones = "LDDDDDDDD";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		int x_esperado_persona = 5;
		int y_esperado_persona = 3;

		int x_esperado_caja = 5;
		int y_esperado_caja = 4;

		boolean caja_en_posicion_correcta = false;
		for (Caja caja : this.escenario.getCajas()){
			if (caja.getX() == x_esperado_caja && caja.getY() == y_esperado_caja){
				caja_en_posicion_correcta = true;
			}
		}
			
		int x_persona = this.escenario.getPersona().getX();
		int y_persona = this.escenario.getPersona().getY();

		assertEquals("El jugador deberia haber quedado en otra pos_x", x_esperado_persona, x_persona);
		assertEquals("El jugador deberia haber quedado en otra pos_y", y_esperado_persona, y_persona);
		assertTrue("No hay cajas en " + x_esperado_caja +", " + y_esperado_caja, caja_en_posicion_correcta);
	}
}