package ar.com.stomalab.souyaban.model.tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.EscenarioLoader;
import ar.com.stomalab.souyaban.model.JugadorAutomatico;

/*class TestJugarNivelEntero < Test::Unit::TestCase
  
 
  def test_14a03_nivel_complejo_movimientos_extras
    escenario_loader = EscenarioLoader.new
    archivo = File.dirname(__FILE__) + '/esquema_test_14A02_nivel_complejo.txt'
    escenario = escenario_loader.cargar_escenario_desde_archivo(archivo)

    jugador_automatico = JugadorAutomatico.new
    jugador_automatico.set_escenario(escenario)

    instrucciones = 'LLDDDDDLUURRRRRRRRDDDDLUUUUULLLLLLLDDDDDDRRRRRRRRRRRULURUULDRDDRRULDLUU'
    jugador_automatico.ejecutar_instrucciones(instrucciones)

    assert_equal(true, escenario.todos_los_destinos_ocupados?, "el nivel deberia estar completo")
  end

end
*/
public class TestJugarNivelCompleto extends TestCase {

	Escenario escenario;
	public void setUp(){
	}
	
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