package ar.com.stomalab.souyaban.model.tests;
import static org.junit.Assert.assertFalse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;
import ar.com.stomalab.souyaban.model.Posicion;

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
		
		Posicion pos_original = persona.getPosicion();
		persona.moverIzquierda();
		Posicion pos_nueva = persona.getPosicion();
		assertThat(pos_nueva, equalTo(pos_original));
		}
	
	@Test
	public void test02A02MoverDerechaOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(4, 3);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseDerecha());
		
		Posicion pos_original = persona.getPosicion();
		persona.moverDerecha();
		Posicion pos_nueva = persona.getPosicion();
		assertThat(pos_nueva, equalTo(pos_original));
	}
	
	@Test
	public void test02A03MoverArribaOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(3, 2);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseArriba());
		
		Posicion pos_original = persona.getPosicion();
		persona.moverArriba();
		Posicion pos_nueva = persona.getPosicion();
		assertThat(pos_nueva, equalTo(pos_original));
	}
	
	@Test
	public void test02A04MoverAbajoOcupado(){
		Persona persona = new Persona();
		persona.setPosicion(3, 4);
		persona.setEscenario(this.escenario);
		
		assertFalse(persona.puedeMoverseAbajo());
		
		Posicion pos_original = persona.getPosicion();
		persona.moverAbajo();
		Posicion pos_nueva = persona.getPosicion();
		assertThat(pos_nueva, equalTo(pos_original));
	}
}