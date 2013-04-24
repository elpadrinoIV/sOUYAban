package ar.com.stomalab.souyaban.model;

public class Caja extends Item {
	Escenario escenario;
	public Caja(){
		super();
	}
	
	public Caja(int x, int y){
		super(x, y);
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	public void moverIzquierda() {
		if (this.escenario.estaLibre(this.getX() - 1, this.getY())){
			this.setPosicion(this.getX() - 1, this.getY());
		}		
	}
	
	public void moverDerecha() {
		if (this.escenario.estaLibre(this.getX() + 1, this.getY())){
			this.setPosicion(this.getX() + 1, this.getY());
		}
	}
	
	public void moverArriba() {
		if (this.escenario.estaLibre(this.getX(), this.getY() - 1)){
			this.setPosicion(this.getX(), this.getY() - 1);
		}
	}
	
	public void moverAbajo() {
		if (this.escenario.estaLibre(this.getX(), this.getY() + 1)){
			this.setPosicion(this.getX(), this.getY() + 1);
		}
	}
	
	@Override
	public boolean ocupaLugar() {
		return true;
	}

	@Override
	public boolean movible() {
		return true;
	}

	
}
