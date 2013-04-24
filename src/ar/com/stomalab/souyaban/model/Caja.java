package ar.com.stomalab.souyaban.model;

public class Caja extends Item {
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
}
