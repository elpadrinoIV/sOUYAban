package ar.com.stomalab.souyaban.model.tests;

import junit.framework.TestCase;

import org.junit.Test;

import ar.com.stomalab.souyaban.model.Caja;
import ar.com.stomalab.souyaban.model.Destino;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.JugadorAutomatico;
import ar.com.stomalab.souyaban.model.Pared;
import ar.com.stomalab.souyaban.model.Persona;

public class TestDeshacer extends TestCase {

	Escenario escenario;
	
	public void setUp(){
		// #######
	    // #  .. #
	    // #   @ #
	    // #   $ #
	    // # $   #
	    // #######
		
		this.escenario = new Escenario();
		this.escenario.agregarPared(new Pared(1,1));
		this.escenario.agregarPared(new Pared(2,1));
		this.escenario.agregarPared(new Pared(3,1));
		this.escenario.agregarPared(new Pared(4,1));
		this.escenario.agregarPared(new Pared(5,1));
		this.escenario.agregarPared(new Pared(6,1));
		this.escenario.agregarPared(new Pared(7,1));
		
		this.escenario.agregarPared(new Pared(1,2));
		this.escenario.agregarDestino(new Destino(4,2));
		this.escenario.agregarDestino(new Destino(5,2));
		this.escenario.agregarPared(new Pared(7,2));
		
		this.escenario.agregarPared(new Pared(1,3));
		Persona persona = new Persona(5, 3);
		persona.setEscenario(this.escenario);
		this.escenario.agregarPersona(persona);
		this.escenario.agregarPared(new Pared(7,3));
		
		this.escenario.agregarPared(new Pared(1,4));
		Caja caja1 = new Caja(5, 4);
		caja1.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja1);
		this.escenario.agregarPared(new Pared(7,4));
		
		this.escenario.agregarPared(new Pared(1,5));
		Caja caja2 = new Caja(3, 5);
		caja2.setEscenario(this.escenario);
		this.escenario.agregarCaja(caja2);
		this.escenario.agregarPared(new Pared(7,5));
		
		this.escenario.agregarPared(new Pared(1,6));
		this.escenario.agregarPared(new Pared(2,6));
		this.escenario.agregarPared(new Pared(3,6));
		this.escenario.agregarPared(new Pared(4,6));
		this.escenario.agregarPared(new Pared(5,6));
		this.escenario.agregarPared(new Pared(6,6));
		this.escenario.agregarPared(new Pared(7,6));
	}
	
	@Test
	public void test13A01ContarMoverLibre(){
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		String instrucciones = "URDLLLDLUURRR";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		assertEquals("Cantidad de movimientos erroneos", instrucciones.length(), this.escenario.getPersona().getCantidadMovimientos() );
	}
	
	@Test
	public void test12A01DeshacerSimpleVolverAOriginal(){
		JugadorAutomatico jugador_automatico = new JugadorAutomatico();
		jugador_automatico.setEscenario(this.escenario);
		
		int x_inicial = this.escenario.getPersona().getX();
		int y_inicial = this.escenario.getPersona().getY();
		String instrucciones = "RULLLDD";
		
		jugador_automatico.ejecutarInstrucciones(instrucciones);
		
		for (int i = 0; i < instrucciones.length(); i++){
			this.escenario.deshacer();
		}
		
		int x_final = this.escenario.getPersona().getX();
		int y_final = this.escenario.getPersona().getY();
		
		assertEquals("El jugador deberia haber quedado en la misma pos_x", x_inicial, x_final);
		assertEquals("El jugador deberia haber quedado en la misma pos_y", y_inicial, y_final);
	}
	
}


/*

def test_12a01_deshacer_simple_volver_a_original
jugador_automatico = JugadorAutomatico.new
jugador_automatico.set_escenario(@escenario)

x_inicial = @escenario.get_persona.get_x
y_inicial = @escenario.get_persona.get_y

instrucciones = 'RULLLDD'
jugador_automatico.ejecutar_instrucciones(instrucciones)
instrucciones.length.times do
  @escenario.deshacer
end

x_final = @escenario.get_persona.get_x
y_final = @escenario.get_persona.get_y


end

def test_12a02_deshacer_simple_varios_undos
# Mover por zona libre (7 movimientos), 1 undo, 3 undos

# #######
# #  .. #
# #   @ #
# #   $ #
# # $   #
# #######

jugador_automatico = JugadorAutomatico.new
jugador_automatico.set_escenario(@escenario)

instrucciones = 'RULLLDD'
jugador_automatico.ejecutar_instrucciones(instrucciones)

@escenario.deshacer
x_esperado = 3
y_esperado = 3

x = @escenario.get_persona.get_x
y = @escenario.get_persona.get_y

assert_equal(x_esperado, x, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado, y, "El jugador deberia haber quedado en otra pos_y")

3.times do
  @escenario.deshacer
end

x_esperado = 5
y_esperado = 2

x = @escenario.get_persona.get_x
y = @escenario.get_persona.get_y

assert_equal(x_esperado, x, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado, y, "El jugador deberia haber quedado en otra pos_y")
end

def test_12a03_deshacer_mas_undos_que_movimientos
jugador_automatico = JugadorAutomatico.new
jugador_automatico.set_escenario(@escenario)

x_inicial = @escenario.get_persona.get_x
y_inicial = @escenario.get_persona.get_y

instrucciones = 'RULLLDD'
jugador_automatico.ejecutar_instrucciones(instrucciones)
(instrucciones.length + 5).times do
  @escenario.deshacer
end

x_final = @escenario.get_persona.get_x
y_final = @escenario.get_persona.get_y

assert_equal(x_inicial, x_final, "El jugador deberia haber quedado en la misma pos_x")
assert_equal(y_inicial, y_final, "El jugador deberia haber quedado en la misma pos_y")
end

def test_12a04_deshacer_zonas_trabadas_no_cuentan
# 12A04 - Mover por zonas libres y trabadas, mover en zona trabada no cuenta para undo.
#
# #######
# #  .. #
# #   @ #
# #   $ #
# # $   #
# #######
jugador_automatico = JugadorAutomatico.new
jugador_automatico.set_escenario(@escenario)

instrucciones = 'RUUUUUU'
jugador_automatico.ejecutar_instrucciones(instrucciones)

@escenario.deshacer

x_esperado = 6
y_esperado = 3

x = @escenario.get_persona.get_x
y = @escenario.get_persona.get_y

assert_equal(x_esperado, x, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado, y, "El jugador deberia haber quedado en otra pos_y")

instrucciones = 'DDDDDDDDDDDLLUUU'
jugador_automatico.ejecutar_instrucciones(instrucciones)

@escenario.deshacer

x_esperado = 4
y_esperado = 3

x = @escenario.get_persona.get_x
y = @escenario.get_persona.get_y

assert_equal(x_esperado, x, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado, y, "El jugador deberia haber quedado en otra pos_y")

5.times do
  @escenario.deshacer
end

x_esperado = 6
y_esperado = 4

x = @escenario.get_persona.get_x
y = @escenario.get_persona.get_y

assert_equal(x_esperado, x, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado, y, "El jugador deberia haber quedado en otra pos_y")
end

def test_12a05_deshacer_cajas_y_zonas_trabadas_no_cuentan
#	12A05 - Mover empujando cajas, trabarse con esas cajas, varias vueltas, varios undos
#
# #######
# #  .. #
# #   @ #
# #   $ #
# # $   #
# #######
jugador_automatico = JugadorAutomatico.new
jugador_automatico.set_escenario(@escenario)

instrucciones = 'RUUUUUU'
jugador_automatico.ejecutar_instrucciones(instrucciones)

@escenario.deshacer

x_esperado = 6
y_esperado = 3

x = @escenario.get_persona.get_x
y = @escenario.get_persona.get_y

assert_equal(x_esperado, x, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado, y, "El jugador deberia haber quedado en otra pos_y")

instrucciones = 'LDDDDDDDD'
jugador_automatico.ejecutar_instrucciones(instrucciones)

@escenario.deshacer

x_esperado_persona = 5
y_esperado_persona = 3

x_esperado_caja = 5
y_esperado_caja = 4

caja_en_posicion_correcta = false
@escenario.get_cajas.each do |caja|
  if caja.get_x == x_esperado_caja && caja.get_y == y_esperado_caja
    caja_en_posicion_correcta = true
  end
end

x_persona = @escenario.get_persona.get_x
y_persona = @escenario.get_persona.get_y

assert_equal(x_esperado_persona, x_persona, "El jugador deberia haber quedado en otra pos_x")
assert_equal(y_esperado_persona, y_persona, "El jugador deberia haber quedado en otra pos_y")
assert_equal(true, caja_en_posicion_correcta, "No hay cajas en #{x_esperado_caja}, #{y_esperado_caja}")
end
*/