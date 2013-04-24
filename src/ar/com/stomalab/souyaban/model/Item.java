package ar.com.stomalab.souyaban.model;

public abstract class Item extends Posicionable{
	public Item(){}
	
	public Item(int x, int y){
		this.setPosicion(x, y);
	}
	
	public abstract boolean ocupaLugar();
}
