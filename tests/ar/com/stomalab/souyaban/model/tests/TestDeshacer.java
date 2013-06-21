package ar.com.stomalab.souyaban.model.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.JugadorAutomatico;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;
import ar.com.stomalab.souyaban.model.Posicion;

import static ar.com.stomalab.souyaban.model.tests.TieneElementosEscenario.deberiaTenerCajaEn;;
public class TestDeshacer{

	Escenario escenario;
	
	@Before
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
		
		Posicion pos_inicial = this.escenario.getPersona().getPosicion();
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		for (int i = 0; i < instrucciones.length(); i++){
			this.escenario.deshacer();
		}
		
		Posicion pos_final = this.escenario.getPersona().getPosicion();
		assertThat(pos_final, equalTo(pos_inicial));
	}
	
	@Test
	public void test12A02DeshacerSimpleVariosUndos(){
		// Mover por zona libre (7 movimientos), 1 undo, 3 undos
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		Posicion posicion_esperada = new Posicion(3, 3);
		
		assertThat(this.escenario.getPersona().getPosicion(), equalTo(posicion_esperada));
	
		for (int i = 0; i < 3; i++){
			this.escenario.deshacer();
		}
		
		posicion_esperada.setPosicion(5, 2);

		assertThat(this.escenario.getPersona().getPosicion(), equalTo(posicion_esperada));
	}

	@Test
	public void test12A03DeshacerMasUndosQueMovimientos(){
		// Mover por zona libre (7 movimientos), 1 undo, 3 undos
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);

		Posicion pos_inicial = this.escenario.getPersona().getPosicion();
		
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		for (int i = 0; i < instrucciones.length() + 5; i++){
			this.escenario.deshacer();
		}		
		
		assertThat(this.escenario.getPersona().getPosicion(), equalTo(pos_inicial));
	}

	@Test
	public void test12A04DeshacerZonasTrabadasNoCuentan(){
		// Mover por zonas libres y trabadas, mover en zona trabada no cuenta para undo.
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RUUUUUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		Posicion pos_esperada = new Posicion(6, 3);
		
		assertThat(this.escenario.getPersona().getPosicion(), equalTo(pos_esperada));
		
		instrucciones = "DDDDDDDDDDDLLUUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);

		this.escenario.deshacer();
		
		pos_esperada.setPosicion(4, 3);
		
		assertThat(this.escenario.getPersona().getPosicion(), equalTo(pos_esperada));
		
		for (int i = 0; i < 5; i++){
			this.escenario.deshacer();
		}

		pos_esperada.setPosicion(6, 4);
		assertThat(this.escenario.getPersona().getPosicion(), equalTo(pos_esperada));
	}
	
	@Test
	public void test12A05DeshacerCajasYZonasTrabadasNoCuentan(){
		// Mover por zonas libres y trabadas, mover en zona trabada no cuenta para undo.
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RUUUUUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
	
		Posicion pos_esperada_persona = new Posicion(6, 3);
		
		assertThat(this.escenario.getPersona().getPosicion(), equalTo(pos_esperada_persona));
		
		instrucciones = "LDDDDDDDD";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		this.escenario.deshacer();
		
		pos_esperada_persona.setPosicion(5,  3);
		
		Posicion pos_esperada_caja = new Posicion(5, 4);

		assertThat(this.escenario.getPersona().getPosicion(), equalTo(pos_esperada_persona));
		assertThat(this.escenario, deberiaTenerCajaEn(pos_esperada_caja));
		//assertTrue("No hay cajas en " + x_esperado_caja +", " + y_esperado_caja, caja_en_posicion_correcta);
	}
}