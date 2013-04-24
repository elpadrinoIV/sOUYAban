package ar.com.stomalab.souyaban.model;

public class Caja extends Item {
	Escenario escenario;
	public Caja(){
		super();
	}
	
	public Caja(int x, int y){
		super(x, y);
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}
}
