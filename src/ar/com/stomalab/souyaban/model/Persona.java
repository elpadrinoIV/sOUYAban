package ar.com.stomalab.souyaban.model;

public class Persona extends Item {
	Escenario escenario;
	private int cantidad_movimientos = 0;
	
	public Persona(){
		super();
	}
	
	public Persona(int x, int y){
		super(x, y);
	}
	
	public boolean puedeMoverseIzquierda() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX() - 1, this.getY()) ||
								this.escenario.itemPuedeMoverseDesdeHastaPosicion(this.getX() - 1, this.getY(), this.getX() - 2, this.getY());
		return puede_moverse;
	}
	
	public boolean puedeMoverseDerecha() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX() + 1, this.getY()) ||
								this.escenario.itemPuedeMoverseDesdeHastaPosicion(this.getX() + 1, this.getY(), this.getX() + 2, this.getY());
		return puede_moverse;
	}
	
	public boolean puedeMoverseArriba() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX(), this.getY() - 1) || 
								this.escenario.itemPuedeMoverseDesdeHastaPosicion(this.getX(), this.getY() - 1, this.getX(), this.getY() - 2);
		return puede_moverse;
	}
	
	public boolean puedeMoverseAbajo() {
		boolean puede_moverse = this.escenario.estaLibre(this.getX(), this.getY() + 1) ||
								this.escenario.itemPuedeMoverseDesdeHastaPosicion(this.getX(), this.getY() + 1, this.getX(), this.getY() + 2);
		return puede_moverse;
	}
	
	public void moverIzquierda() {
		Historia historia = this.escenario.getHistoria();
		historia.empezarEvento();
		if (this.puedeMoverseIzquierda()){
			Caja caja_a_la_izquierda = this.cajaEnPosicion(this.getX() - 1, this.getY());
			if (null != caja_a_la_izquierda){
				historia.cajaSeMovio(caja_a_la_izquierda, this.getX() - 1, this.getY(), this.getX() - 2, this.getY());
				caja_a_la_izquierda.moverIzquierda();
			}
			
			historia.personaSeMovio(this, this.getX(), this.getY(), this.getX() - 1, this.getY());		
			this.setPosicion(this.getX() - 1, this.getY());
			this.cantidad_movimientos++;
		}
		
		historia.terminarEvento();
	}
	
	public void moverDerecha() {
		Historia historia = this.escenario.getHistoria();
		historia.empezarEvento();
		
		if (this.puedeMoverseDerecha()){
			Caja caja_a_la_derecha = this.cajaEnPosicion(this.getX() + 1, this.getY());
			if (null != caja_a_la_derecha){
				historia.cajaSeMovio(caja_a_la_derecha, this.getX() + 1, this.getY(), this.getX() + 2, this.getY());
				caja_a_la_derecha.moverDerecha();
			}
					
			historia.personaSeMovio(this, this.getX(), this.getY(), this.getX() + 1, this.getY());
			this.setPosicion(this.getX() + 1, this.getY());
			this.cantidad_movimientos++;
		}
		
		historia.terminarEvento();
	}
	
	public void moverArriba() {
		Historia historia = this.escenario.getHistoria();
		historia.empezarEvento();
		
		if (this.puedeMoverseArriba()){
			Caja caja_arriba = this.cajaEnPosicion(this.getX(), this.getY() - 1);
			if (null != caja_arriba){
				historia.cajaSeMovio(caja_arriba, this.getX(), this.getY() - 1, this.getX(), this.getY() - 2);
				caja_arriba.moverArriba();
			}
					
			historia.personaSeMovio(this, this.getX(), this.getY(), this.getX(), this.getY() - 1);
			this.setPosicion(this.getX(), this.getY() - 1);
			this.cantidad_movimientos++;
		}
		
		historia.terminarEvento();
	}
	
	public void moverAbajo() {
		Historia historia = this.escenario.getHistoria();
		historia.empezarEvento();
		
		if (this.puedeMoverseAbajo()){
			Caja caja_abajo = this.cajaEnPosicion(this.getX(), this.getY() + 1);
			if (null != caja_abajo){
				historia.cajaSeMovio(caja_abajo, this.getX(), this.getY() + 1, this.getX(), this.getY() + 2);
				caja_abajo.moverAbajo();
			}
					
			historia.personaSeMovio(this, this.getX(), this.getY(), this.getX(), this.getY() + 1);
			this.setPosicion(this.getX(), this.getY() + 1);
			this.cantidad_movimientos++;
		}
		
		historia.terminarEvento();
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	
	@Override
	public boolean movible() {
		return false;
	}
	
	public void setEscenario(Escenario escenario){
		this.escenario = escenario;
	}
	
	private Caja cajaEnPosicion(int x, int y){
		Caja caja_en_posicion = null;
		
		for (Caja caja : this.escenario.getCajas()){
			if (caja.getX() == x && caja.getY() == y){
				caja_en_posicion = caja;
			}
		}
		
		return caja_en_posicion;
	}

	public int getCantidadMovimientos() {
		return this.cantidad_movimientos;
	}
}

