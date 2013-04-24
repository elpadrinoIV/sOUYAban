package ar.com.stomalab.souyaban.model;

public class Pared extends Item {
	public Pared(){
		super();
	}
	
	public Pared(int x, int y){
		super(x, y);
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
}
