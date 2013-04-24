package ar.com.stomalab.souyaban.model.tests;

import junit.framework.TestCase;

import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;

public class TestEmpujarCajas extends TestCase {

	Escenario escenario;
	
	public void setUp(){
		// #####
		// #   #
		// #   #
		// #   #
		// #####
		
		this.escenario = new Escenario();
		this.escenario.agregarPared(new Pared(1,1));
		this.escenario.agregarPared(new Pared(2,1));
		this.escenario.agregarPared(new Pared(3,1));
		this.escenario.agregarPared(new Pared(4,1));
		this.escenario.agregarPared(new Pared(5,1));
		this.escenario.agregarPared(new Pared(6,1));
		
		this.escenario.agregarPared(new Pared(1,2));
		this.escenario.agregarPared(new Pared(6,2));
		
		this.escenario.agregarPared(new Pared(1,3));
		this.escenario.agregarPared(new Pared(6,3));
		
		this.escenario.agregarPared(new Pared(1,4));
		this.escenario.agregarPared(new Pared(6,4));
		
		this.escenario.agregarPared(new Pared(1,5));
		this.escenario.agregarPared(new Pared(2,5));
		this.escenario.agregarPared(new Pared(3,5));
		this.escenario.agregarPared(new Pared(4,5));
		this.escenario.agregarPared(new Pared(5,5));
		this.escenario.agregarPared(new Pared(6,5));
	}
	
	@Test
	public void test05A01EmpujarCajaIzquierdaLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(4, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverIzquierda();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se movio a la izquierda", x_original_caja - 1, x_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja, y_nuevo_caja);
	    assertEquals("el tipito no se movio a la izquierda", x_original_persona - 1, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A02EmpujarCajaDerechaLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(2, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverDerecha();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se movio a la derecha", x_original_caja + 1, x_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja, y_nuevo_caja);
	    assertEquals("el tipito no se movio a la derecha	", x_original_persona + 1, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A03EmpujarCajaArribaLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 4);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverArriba();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja, x_nuevo_caja);
	    assertEquals("la caja no se movio arriba", y_original_caja - 1, y_nuevo_caja);
	    assertEquals("el tipito no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se movio arriba", y_original_persona - 1, y_nuevo_persona);
	}

	@Test
	public void test05A04EmpujarCajaAbajoLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 2);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverAbajo();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja, x_nuevo_caja);
	    assertEquals("la caja no se movio abajo", y_original_caja + 1, y_nuevo_caja);
	    assertEquals("el tipito no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se movio abajo", y_original_persona + 1, y_nuevo_persona);
	}
	
	@Test
	public void test05A05EmpujarCajaIzquierdaOcupadoConPared(){
		Caja caja = new Caja(2, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverIzquierda();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja, x_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja, y_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A06EmpujarCajaDerechaOcupadoConPared(){
		Caja caja = new Caja(5, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(4, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverDerecha();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja, x_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja, y_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A07EmpujarCajaArribaOcupadoConPared(){
		Caja caja = new Caja(3, 2);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverArriba();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja, x_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja, y_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A08EmpujarCajaAbajoOcupadoConPared(){
		Caja caja = new Caja(3, 5);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 4);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja = caja.getX();
	    int y_original_caja = caja.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverAbajo();
	    int x_nuevo_caja = caja.getX();
	    int y_nuevo_caja = caja.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja, x_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja, y_nuevo_caja);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A09EmpujarCajaIzquierdaOcupadoConCaja(){
		Caja caja_izq = new Caja(3, 3);
		this.escenario.agregarCaja(caja_izq);
		caja_izq.setEscenario(this.escenario);
		
		Caja caja_der = new Caja(4, 3);
		this.escenario.agregarCaja(caja_der);
		caja_der.setEscenario(this.escenario);
		
		Persona persona = new Persona(5, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja_izq = caja_izq.getX();
	    int y_original_caja_izq = caja_izq.getY();
	    int x_original_caja_der = caja_der.getX();
	    int y_original_caja_der = caja_der.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverIzquierda();
	    int x_nuevo_caja_izq = caja_izq.getX();
	    int y_nuevo_caja_izq = caja_izq.getY();
	    int x_nuevo_caja_der = caja_der.getX();
	    int y_nuevo_caja_der = caja_der.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja_izq, x_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_izq, y_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en x", x_original_caja_der, x_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_der, y_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A10EmpujarCajaDerechaOcupadoConCaja(){
		Caja caja_izq = new Caja(3, 3);
		this.escenario.agregarCaja(caja_izq);
		caja_izq.setEscenario(this.escenario);
		
		Caja caja_der = new Caja(4, 3);
		this.escenario.agregarCaja(caja_der);
		caja_der.setEscenario(this.escenario);
		
		Persona persona = new Persona(2, 3);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja_izq = caja_izq.getX();
	    int y_original_caja_izq = caja_izq.getY();
	    int x_original_caja_der = caja_der.getX();
	    int y_original_caja_der = caja_der.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverDerecha();
	    int x_nuevo_caja_izq = caja_izq.getX();
	    int y_nuevo_caja_izq = caja_izq.getY();
	    int x_nuevo_caja_der = caja_der.getX();
	    int y_nuevo_caja_der = caja_der.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja_izq, x_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_izq, y_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en x", x_original_caja_der, x_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_der, y_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A11EmpujarCajaArribaOcupadoConCaja(){
		Caja caja_izq = new Caja(3, 3);
		this.escenario.agregarCaja(caja_izq);
		caja_izq.setEscenario(this.escenario);
		
		Caja caja_der = new Caja(3, 4);
		this.escenario.agregarCaja(caja_der);
		caja_der.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 5);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja_izq = caja_izq.getX();
	    int y_original_caja_izq = caja_izq.getY();
	    int x_original_caja_der = caja_der.getX();
	    int y_original_caja_der = caja_der.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverArriba();
	    int x_nuevo_caja_izq = caja_izq.getX();
	    int y_nuevo_caja_izq = caja_izq.getY();
	    int x_nuevo_caja_der = caja_der.getX();
	    int y_nuevo_caja_der = caja_der.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja_izq, x_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_izq, y_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en x", x_original_caja_der, x_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_der, y_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
	
	@Test
	public void test05A12EmpujarCajaAbajoOcupadoConCaja(){
		Caja caja_izq = new Caja(3, 3);
		this.escenario.agregarCaja(caja_izq);
		caja_izq.setEscenario(this.escenario);
		
		Caja caja_der = new Caja(3, 4);
		this.escenario.agregarCaja(caja_der);
		caja_der.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 2);
		persona.setEscenario(this.escenario);
			    
	    int x_original_caja_izq = caja_izq.getX();
	    int y_original_caja_izq = caja_izq.getY();
	    int x_original_caja_der = caja_der.getX();
	    int y_original_caja_der = caja_der.getY();
	    int x_original_persona = persona.getX();
	    int y_original_persona = persona.getY();
	    persona.moverAbajo();
	    int x_nuevo_caja_izq = caja_izq.getX();
	    int y_nuevo_caja_izq = caja_izq.getY();
	    int x_nuevo_caja_der = caja_der.getX();
	    int y_nuevo_caja_der = caja_der.getY();
	    int x_nuevo_persona = persona.getX();
	    int y_nuevo_persona = persona.getY();

	    assertEquals("la caja no se tiene que mover en x", x_original_caja_izq, x_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_izq, y_nuevo_caja_izq);
	    assertEquals("la caja no se tiene que mover en x", x_original_caja_der, x_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en y", y_original_caja_der, y_nuevo_caja_der);
	    assertEquals("la caja no se tiene que mover en x", x_original_persona, x_nuevo_persona);
	    assertEquals("el tipito no se tiene que mover en y", y_original_persona, y_nuevo_persona);
	}
}
