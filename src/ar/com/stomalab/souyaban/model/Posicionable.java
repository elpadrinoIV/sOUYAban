package ar.com.stomalab.souyaban.model;

public abstract class Posicionable {
	private int x;
	private int y;
	
	public Posicionable(){
		this.x = 0;
		this.y = 0;
	}
	
	public void setPosicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y; 
	}
}
