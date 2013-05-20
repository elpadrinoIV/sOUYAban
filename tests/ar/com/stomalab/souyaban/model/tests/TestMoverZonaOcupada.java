package ar.com.stomalab.souyaban.model.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;

public class TestMoverZonaOcupada{
	Escenario escenario;
		
	@Before
	public void setUp(){
		// #####
	    // #   #
	    // #   #
	    // #   #
	    // #####
		
		this.escenario = new Escenario();
		escenario.agregarPared(new Pared(1, 1));
		escenario.agregarPared(new Pared(2, 1));
		escenario.agregarPared(new Pared(3, 1));
		escenario.agregarPared(new Pared(4, 1));
		escenario.agregarPared(new Pared(5, 1));
		
		escenario.agregarPared(new Pared(1, 2));
		escenario.agregarPared(new Pared(5, 2));
		
		escenario.agregarPared(new Pared(1, 3));
		escenario.agregarPared(new Pared(5, 3));
		
		escenario.agregarPared(new Pared(1, 4));
		escenario.agregarPared(new Pared(5, 4));
		
		escenario.agregarPared(new Pared(1, 5));
		escenario.agregarPared(new Pared(2, 5));
		escenario.agregarPared(new Pared(3, 5));
		escenario.agregarPared(new Pared(4, 5));
		escenario.agregarPared(new Pared(5, 5));
	}
	
	@Test
	public void test02A01MoverIzquierdaOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(2, 3);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseIzquierda());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverIzquierda();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se tiene que mover en x", x_original, x_nuevo);
		assertEquals("no se tiene que mover en y", y_original, y_nuevo);
	}
	
	@Test
	public void test02A02MoverDerechaOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(4, 3);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseDerecha());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverDerecha();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se tiene que mover en x", x_original, x_nuevo);
		assertEquals("no se tiene que mover en y", y_original, y_nuevo);
	}
	
	@Test
	public void test02A03MoverArribaOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(3, 2);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseArriba());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverArriba();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se tiene que mover en x", x_original, x_nuevo);
		assertEquals("no se tiene que mover en y", y_original, y_nuevo);
	}
	
	@Test
	public void test02A04MoverAbajoOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(3, 4);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseAbajo());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverAbajo();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se tiene que mover en x", x_original, x_nuevo);
		assertEquals("no se tiene que mover en y", y_original, y_nuevo);
	}
}