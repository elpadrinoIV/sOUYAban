package ar.com.stomalab.souyaban.model.tests;
import org.junit.Test;

import junit.framework.TestCase;
import ar.com.stomalab.souyaban.model.*;

public class TestZonaLibre extends TestCase {
	/*
	public TestZonaLibre(){
		super();
	}
	*/
	Escenario escenario;
	public void setUp(){
		this.escenario = new Escenario(); 
	}
	@Test
	public void test01A01MoverIzquierdaLibre(){
		Persona persona = new Persona();
		persona.setPosicion(5, 2);
		
		assertTrue(persona.puedeMoverseIzquierda());
		
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