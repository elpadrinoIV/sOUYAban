package ar.com.stomalab.souyaban.model.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.JugadorAutomatico;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;

public class TestContarMovimientos {

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
	public void test13A01ContarMoverLibre(){
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "URDLLLDLUURRR";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertEquals("Cantidad de movimientos erroneos", instrucciones.length(), this.escenario.getPersona().getCantidadMovimientos() );
	}
	
	@Test
	public void test13A02ContarMoverLibreYEmpujar(){
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RDLDLULURURDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertEquals("Cantidad de movimientos erroneos", instrucciones.length(), this.escenario.getPersona().getCantidadMovimientos() );
	}
	
	@Test
	public void test13A03ContarMoverLibreYEmpujarYParedesYCajasBloqueadas(){
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "RDLDLUU" + "UUUUUU" + "LL" + "LLLLLL" + "DD" + "DDDDD" + "RRR" + "RRRRRR";
		int cantidad_movimientos_reales = 7 + 2 + 2 + 3;
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertEquals("Cantidad de movimientos erroneos", cantidad_movimientos_reales, this.escenario.getPersona().getCantidadMovimientos() );
	}
}
