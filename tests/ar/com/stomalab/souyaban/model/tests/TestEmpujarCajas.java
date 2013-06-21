package ar.com.stomalab.souyaban.model.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;
import ar.com.stomalab.souyaban.model.Posicion;

public class TestEmpujarCajas{

	Escenario escenario;
	
	@Before
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
			    
		Posicion pos_esperada_caja = caja.getPosicion().plus(new Posicion(-1, 0));
		Posicion pos_esperada_persona = persona.getPosicion().plus(new Posicion(-1, 0));
	    persona.moverIzquierda();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));	
	}
	
	@Test
	public void test05A02EmpujarCajaDerechaLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(2, 3);
		persona.setEscenario(this.escenario);
			    
		Posicion pos_esperada_caja = caja.getPosicion().plus(new Posicion(1, 0));
		Posicion pos_esperada_persona = persona.getPosicion().plus(new Posicion(1, 0));
	    persona.moverDerecha();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}

	@Test
	public void test05A03EmpujarCajaArribaLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 4);
		persona.setEscenario(this.escenario);
			    
		Posicion pos_esperada_caja = caja.getPosicion().plus(new Posicion(0, -1));
		Posicion pos_esperada_persona = persona.getPosicion().plus(new Posicion(0, -1));
	    persona.moverArriba();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}

	@Test
	public void test05A04EmpujarCajaAbajoLibre(){
		Caja caja = new Caja(3, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 2);
		persona.setEscenario(this.escenario);
			    
		Posicion pos_esperada_caja = caja.getPosicion().plus(new Posicion(0, 1));
		Posicion pos_esperada_persona = persona.getPosicion().plus(new Posicion(0, 1));
	    persona.moverAbajo();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}

	@Test
	public void test05A05EmpujarCajaIzquierdaOcupadoConPared(){
		Caja caja = new Caja(2, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 3);
		persona.setEscenario(this.escenario);
			    
		Posicion pos_esperada_caja = caja.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	    persona.moverIzquierda();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}
	
	@Test
	public void test05A06EmpujarCajaDerechaOcupadoConPared(){
		Caja caja = new Caja(5, 3);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(4, 3);
		persona.setEscenario(this.escenario);
		Posicion pos_esperada_caja = caja.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	    persona.moverDerecha();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}
	
	@Test
	public void test05A07EmpujarCajaArribaOcupadoConPared(){
		Caja caja = new Caja(3, 2);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 3);
		persona.setEscenario(this.escenario);
			    
		Posicion pos_esperada_caja = caja.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	    persona.moverArriba();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}
	
	@Test
	public void test05A08EmpujarCajaAbajoOcupadoConPared(){
		Caja caja = new Caja(3, 5);
		this.escenario.agregarCaja(caja);
		caja.setEscenario(this.escenario);
		
		Persona persona = new Persona(3, 4);
		persona.setEscenario(this.escenario);
			    
		Posicion pos_esperada_caja = caja.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	    persona.moverAbajo();
	    
	    Posicion pos_nueva_caja = caja.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja, equalTo(pos_esperada_caja));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));

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
	
		Posicion pos_esperada_caja_izq = caja_izq.getPosicion();
		Posicion pos_esperada_caja_der = caja_der.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	    
		persona.moverIzquierda();
	    
	    Posicion pos_nueva_caja_izq = caja_izq.getPosicion();
	    Posicion pos_nueva_caja_der = caja_der.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja_izq, equalTo(pos_esperada_caja_izq));
	    assertThat(pos_nueva_caja_der, equalTo(pos_esperada_caja_der));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
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
			    
		Posicion pos_esperada_caja_izq = caja_izq.getPosicion();
		Posicion pos_esperada_caja_der = caja_der.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	
		persona.moverDerecha();
	    
	    Posicion pos_nueva_caja_izq = caja_izq.getPosicion();
	    Posicion pos_nueva_caja_der = caja_der.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja_izq, equalTo(pos_esperada_caja_izq));
	    assertThat(pos_nueva_caja_der, equalTo(pos_esperada_caja_der));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
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
			    
		Posicion pos_esperada_caja_izq = caja_izq.getPosicion();
		Posicion pos_esperada_caja_der = caja_der.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
	
		persona.moverArriba();
	    
	    Posicion pos_nueva_caja_izq = caja_izq.getPosicion();
	    Posicion pos_nueva_caja_der = caja_der.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja_izq, equalTo(pos_esperada_caja_izq));
	    assertThat(pos_nueva_caja_der, equalTo(pos_esperada_caja_der));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
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
			    
		Posicion pos_esperada_caja_izq = caja_izq.getPosicion();
		Posicion pos_esperada_caja_der = caja_der.getPosicion();
		Posicion pos_esperada_persona = persona.getPosicion();
		
	    persona.moverAbajo();
	    
	    Posicion pos_nueva_caja_izq = caja_izq.getPosicion();
	    Posicion pos_nueva_caja_der = caja_der.getPosicion();
	    Posicion pos_nueva_persona = persona.getPosicion();

	    assertThat(pos_nueva_caja_izq, equalTo(pos_esperada_caja_izq));
	    assertThat(pos_nueva_caja_der, equalTo(pos_esperada_caja_der));
	    assertThat(pos_nueva_persona, equalTo(pos_esperada_persona));
	}
}
