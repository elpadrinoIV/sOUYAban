package ar.com.stomalab.souyaban.model;


public class JugadorAutomatico {
	Escenario escenario;
	
	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	public void ejecutarInstrucciones(String instrucciones) {
		Persona persona = this.escenario.getPersona();
		for (int i = 0; i < instrucciones.length(); i++){
			switch (instrucciones.charAt(i)){
			case 'R':
				persona.moverDerecha();
				break;
			case 'L':
				persona.moverIzquierda();
				break;
			case 'U':
				persona.moverArriba();
				break;
			case 'D':
				persona.moverAbajo();
				break;
			}
		}
	}
}

