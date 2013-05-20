package ar.com.stomalab.souyaban.model.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;

public class TestNivelCompleto{

	Escenario escenario;
	
	@Before
	public void setUp(){
		// #####
		// #.  #
		// # . #
		// #  .#
		// #####
		
		this.escenario = new Escenario();
		this.escenario.agregarPared(new Pared(1,1));
		this.escenario.agregarPared(new Pared(2,1));
		this.escenario.agregarPared(new Pared(3,1));
		this.escenario.agregarPared(new Pared(4,1));
		this.escenario.agregarPared(new Pared(5,1));
		
		this.escenario.agregarPared(new Pared(1,2));
		this.escenario.agregarDestino(new Destino(2,2));
		this.escenario.agregarPared(new Pared(5,2));
		
		this.escenario.agregarPared(new Pared(1,3));
		this.escenario.agregarDestino(new Destino(3,3));
		this.escenario.agregarPared(new Pared(5,3));
		
		this.escenario.agregarPared(new Pared(1,4));
		this.escenario.agregarDestino(new Destino(4,4));
		this.escenario.agregarPared(new Pared(5,4));
		
		this.escenario.agregarPared(new Pared(1,5));
		this.escenario.agregarPared(new Pared(2,5));
		this.escenario.agregarPared(new Pared(3,5));
		this.escenario.agregarPared(new Pared(4,5));
		this.escenario.agregarPared(new Pared(5,5));
	}
	
	@Test
	public void test03A013Luces3Cajas(){
		Caja caja1 = new Caja(2, 2);
		caja1.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja1);
		
		Caja caja2 = new Caja(3, 3);
		caja2.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja2);
		
		Caja caja3 = new Caja(4, 4);
		caja3.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja3);
		
		assertTrue("todos los destinos deberian estar ocupados", this.escenario.todosLosDestinosOcupados());
	}
	
	@Test
	public void test03A013Luces4Cajas(){
		Caja caja1 = new Caja(2, 2);
		caja1.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja1);
		
		Caja caja2 = new Caja(3, 3);
		caja2.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja2);
		
		Caja caja3 = new Caja(4, 4);
		caja3.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja3);
		
		Caja caja4 = new Caja(4, 3);
		caja4.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja4);
		
		assertTrue("todos los destinos deberian estar ocupados", this.escenario.todosLosDestinosOcupados());
	}
}
