package ar.com.stomalab.souyaban.model.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;

public class TestZonaLibre{
	Escenario escenario;
		
	@Before
	public void setUp(){
		// ######
		// #.# .#
		// # ####
		// ###
		
		this.escenario = new Escenario();
		escenario.agregarPared(new Pared(1,1));
		escenario.agregarPared(new Pared(2,1));
		escenario.agregarPared(new Pared(3,1));
		escenario.agregarPared(new Pared(4,1));
		escenario.agregarPared(new Pared(5,1));
		escenario.agregarPared(new Pared(6,1));
		
		escenario.agregarPared(new Pared(1,2));
		escenario.agregarDestino(new Destino(2,2));
		escenario.agregarPared(new Pared(3,2));
		escenario.agregarDestino(new Destino(5,2));
		escenario.agregarPared(new Pared(6,2));
		
		escenario.agregarPared(new Pared(1,3));
		escenario.agregarPared(new Pared(3,3));
		escenario.agregarPared(new Pared(4,3));
		escenario.agregarPared(new Pared(5,3));
		escenario.agregarPared(new Pared(6,3));
		
		escenario.agregarPared(new Pared(1,4));
		escenario.agregarPared(new Pared(2,4));
		escenario.agregarPared(new Pared(3,4));
	}
	
	@Test
	public void test01A01MoverIzquierdaLibre(){
		Persona persona = new Persona();
		persona.setPosicion(5, 2);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseIzquierda());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverIzquierda();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se movio a la izquierda", x_original - 1, x_nuevo);
		assertEquals("no se tiene que mover en y", y_original, y_nuevo);
	}
	
	@Test
	public void test01A02MoverDerechaLibre(){
		Persona persona = new Persona();
		persona.setPosicion(4, 2);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseDerecha());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverDerecha();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se movio a la derecha", x_original + 1, x_nuevo);
		assertEquals("no se tiene que mover en y", y_original, y_nuevo);
	}
	
	@Test
	public void test01A03MoverArribaLibre(){
		Persona persona = new Persona();
		persona.setPosicion(2, 3);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseArriba());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverArriba();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se tiene que mover en x", x_original, x_nuevo);
		assertEquals("no se movio arriba", y_original - 1, y_nuevo);
	}
	
	@Test
	public void test01A04MoverAbajoLibre(){
		Persona persona = new Persona();
		persona.setPosicion(2, 2);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseAbajo());
		
		int x_original = persona.getX();
		int y_original = persona.getY();
		persona.moverAbajo();
		int x_nuevo = persona.getX();
		int y_nuevo = persona.getY();
		
		assertEquals("no se tiene que mover en x", x_original, x_nuevo);
		assertEquals("no se movio abajo", y_original + 1, y_nuevo);
	}
}

/*
x_original = tipito.get_x
y_original = tipito.get_y
tipito.mover_izquierda
x_nuevo = tipito.get_x
y_nuevo = tipito.get_y

assert_equal(x_original - 1, x_nuevo, "no se movio a la izquierda")
assert_equal(y_original, y_nuevo, "no se tiene que mover en y")
end
*/