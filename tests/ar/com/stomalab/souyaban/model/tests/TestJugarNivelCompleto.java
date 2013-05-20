package ar.com.stomalab.souyaban.model.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.EscenarioLoader;
import ar.com.stomalab.souyaban.model.JugadorAutomatico;


public class TestJugarNivelCompleto{

	Escenario escenario;
	
	@Test
	public void test14A01NivelTrivial(){
		EscenarioLoader escenario_loader = new EscenarioLoader();
		ArrayList<String> lineas = new ArrayList<String>();

		lineas.add("  ###  ");
		lineas.add("  #.#  ");
		lineas.add("###$###");
		lineas.add("#.$@$.#");
		lineas.add("###$###");
		lineas.add("  #.#  ");
		lineas.add("  ###  ");
		
		Escenario escenario = escenario_loader.cargarEscenario(lineas);
		
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(escenario);
		
		String instrucciones = "UDLRRLD";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertTrue("el nivel deberia estar completo", escenario.todosLosDestinosOcupados());
	}
	
	@Test
	public void test14A02NivelComplejo(){
		EscenarioLoader escenario_loader = new EscenarioLoader();
		ArrayList<String> lineas = new ArrayList<String>();

		lineas.add("####  ");
		lineas.add("# .#  ");
		lineas.add("#  ###");
		lineas.add("#*@  #");
		lineas.add("#  $ #");
		lineas.add("#  ###");
		lineas.add("####  ");
		
		Escenario escenario = escenario_loader.cargarEscenario(lineas);
		
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(escenario);
		
		String instrucciones = "DLURRRDLULLDDRULURUULDRDDRRULDLUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertTrue("el nivel deberia estar completo", escenario.todosLosDestinosOcupados());
	}
	
	public void test14A03NivelComplejoConMovimientosExtras(){
		EscenarioLoader escenario_loader = new EscenarioLoader();
		ArrayList<String> lineas = new ArrayList<String>();

		lineas.add("####  ");
		lineas.add("# .#  ");
		lineas.add("#  ###");
		lineas.add("#*@  #");
		lineas.add("#  $ #");
		lineas.add("#  ###");
		lineas.add("####  ");
		
		Escenario escenario = escenario_loader.cargarEscenario(lineas);
		
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(escenario);
		
		String instrucciones = "LLDDDDDLUURRRRRRRRDDDDLUUUUULLLLLLLDDDDDDRRRRRRRRRRRULURUULDRDDRRULDLUU";
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertTrue("el nivel deberia estar completo", escenario.todosLosDestinosOcupados());
	}
}