package ar.com.stomalab.souyaban.model.tests;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.Posicion;

public class TieneElementosEscenario {
	public static Matcher<Escenario> deberiaTenerCajaEn(final Posicion posicion) {
	      
		return new TypeSafeMatcher<Escenario>() {
	        @Override
	        public void describeTo(Description description) { 
	        	description.appendText("Caja en (" + posicion.getX() + ", " + posicion.getY() + ")");
	        }
	        
	        @Override
	        public boolean matchesSafely(Escenario escenario) { 
	        	boolean caja_en_posicion_correcta = false;
	    		for (Caja caja : escenario.getCajas()){
	    			if (caja.getX() == posicion.getX() && caja.getY() == posicion.getY()){
	    				caja_en_posicion_correcta = true;
	    			}
	    		}
	    		
	    		return caja_en_posicion_correcta;
	        }
	        
	        public void describeMismatchSafely(Escenario escenario, Description mismatchDescription) {
	            mismatchDescription.appendText("no hay caja ahi");
	          } 
	      };
	    }
}
