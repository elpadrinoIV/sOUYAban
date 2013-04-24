package ar.com.stomalab.souyaban.model;

public class Destino extends Item {
	public Destino(){
		super();
	}
	
	public Destino(int x, int y){
		super(x, y);
	}

	@Override
	public boolean ocupaLugar() {
		return false;
	}
	
	@Override
	public boolean movible() {
		return false;
	}
}
