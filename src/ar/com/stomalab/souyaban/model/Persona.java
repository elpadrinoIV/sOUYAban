package ar.com.stomalab.souyaban.model;

public class Persona extends Item {
	Escenario escenario;
	
	public Persona(){
		super();
	}
	
	public Persona(int x, int y){
		super(x, y);
	}
	
	public boolean puedeMoverseIzquierda() {
		// @escenario.esta_libre?(@x - 1, @y) || @escenario.item_puede_moverse_desde_hasta_posicion?(@x - 1, @y, @x - 2, @y)
		boolean puede_moverse = this.escenario.estaLibre(this.getX() - 1, this.getY());
		return puede_moverse;
	}
	
	public boolean puedeMoverseDerecha() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX() + 1, this.getY());
		return puede_moverse;
	}
	
	public boolean puedeMoverseArriba() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX(), this.getY() - 1);
		return puede_moverse;
	}
	
	public boolean puedeMoverseAbajo() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX(), this.getY() + 1);
		return puede_moverse;
	}
	
	public void moverIzquierda() {
		if (this.puedeMoverseIzquierda()){
			this.setPosicion(this.getX() - 1, this.getY());
		}

		/*
	    if puede_moverse_izquierda?
	    	      caja_a_la_izquierda = caja_en_posicion(@x - 1, @y)
	    	      if nil != caja_a_la_izquierda
	    	        caja_a_la_izquierda.mover_izquierda
	    	      end
	    	      @x = @x - 1
	    	    end
	    	  end
*/		
	}
	
	public void moverDerecha() {
		if (this.puedeMoverseDerecha()){
			this.setPosicion(this.getX() + 1, this.getY());
		}
	}
	
	public void moverArriba() {
		if (this.puedeMoverseArriba()){
			this.setPosicion(this.getX(), this.getY() - 1);
		}
	}
	
	public void moverAbajo() {
		if (this.puedeMoverseAbajo()){
			this.setPosicion(this.getX(), this.getY() + 1);
		}
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	
	public void setEscenario(Escenario escenario){
		this.escenario = escenario;
	}
}

