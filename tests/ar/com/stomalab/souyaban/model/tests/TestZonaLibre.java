package ar.com.stomalab.souyaban.model.tests;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;
import ar.com.stomalab.souyaban.model.Posicion;

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
		
		Posicion pos_esperada = persona.getPosicion().plus(new Posicion(-1, 0));
		persona.moverIzquierda();
		Posicion pos_nueva = persona.getPosicion();
		
		assertThat(pos_nueva, equalTo(pos_esperada));
	}
	
	@Test
	public void test01A02MoverDerechaLibre(){
		Persona persona = new Persona();
		persona.setPosicion(4, 2);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseDerecha());
		
		Posicion pos_esperada = persona.getPosicion().plus(new Posicion(1, 0));
		persona.moverDerecha();
		Posicion pos_nueva = persona.getPosicion();
	
		assertThat(pos_nueva, equalTo(pos_esperada));
	}
	
	
	@Test
	public void test01A03MoverArribaLibre(){
		Persona persona = new Persona();
		persona.setPosicion(2, 3);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseArriba());
		
		Posicion pos_esperada = persona.getPosicion().plus(new Posicion(0, -1));
		persona.moverArriba();
		Posicion pos_nueva = persona.getPosicion();
	
		assertThat(pos_nueva, equalTo(pos_esperada));
	}
	
	@Test
	public void test01A04MoverAbajoLibre(){
		Persona persona = new Persona();
		persona.setPosicion(2, 2);
		persona.setEscenario(this.escenario);
		
		assertTrue(persona.puedeMoverseAbajo());
		
		Posicion pos_esperada = persona.getPosicion().plus(new Posicion(0, 1));
		persona.moverAbajo();
		Posicion pos_nueva = persona.getPosicion();
	
		assertThat(pos_nueva, equalTo(pos_esperada));
	}
}