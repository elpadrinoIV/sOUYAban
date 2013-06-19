package ar.com.stomalab.souyaban.model;

public abstract class Posicionable {
	Posicion posicion;
	
	public Posicionable(){
		this.posicion = new Posicion(0, 0);
	}
	
	public void setPosicion(int x, int y){
		this.posicion.setX(x);
		this.posicion.setY(y);
	}
	
	public int getX(){
		return this.posicion.getX();
	}
	
	public int getY(){
		return this.posicion.getY();
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
}
