package ar.com.stomalab.souyaban.model;

import java.util.ArrayList;


public class Escenario {
	private ArrayList<Destino> destinos;
	private ArrayList<Pared> paredes;
	private ArrayList<Caja> cajas;
		
	private Persona persona;
	
	private Historia historia;
		
	public Escenario()
	{
		this.destinos = new ArrayList<Destino>();
		this.paredes = new ArrayList<Pared>();
		this.cajas = new ArrayList<Caja>();
		this.historia = new Historia();
	}
	
	public void agregarDestino(Destino destino){
		this.destinos.add(destino);
	}
	
	public void agregarPared(Pared pared){
		this.paredes.add(pared);
	}
	
	public void agregarCaja(Caja caja){
		this.cajas.add(caja);
	}
	
	public void agregarPersona(Persona persona){
		this.persona = persona;
	}
	
	public int getAncho(){
		return 10;
	}
	
	public int getAlto(){
		return 10;
	}
	
	public char[][] getRepresentacion(){
		int ancho = this.getAncho();
		int alto = this.getAlto();
		char[][] representacion = new char[alto][ancho];
		
		for (int fila = 0; fila < alto; fila++){
			for (int columna = 0; columna < ancho; columna++){
				representacion[fila][columna] = ' ';
				
			}
		}
		
		for (Pared pared : this.paredes){
			representacion[pared.getY() - 1][pared.getX() - 1] = '#';
		}
		
		for (Destino destino : this.destinos){
			representacion[destino.getY() - 1][destino.getX() - 1] = '.';
		}
		
		for (Caja caja : this.cajas){
			if ('.' == representacion[caja.getY() - 1][caja.getX() - 1]){
				representacion[caja.getY() - 1][caja.getX() - 1] = '*';
			}else{
				representacion[caja.getY() - 1][caja.getX() - 1] = '$';
			}
		}
		
		if ('.' == representacion[this.persona.getY() - 1][this.persona.getX() - 1]){
			representacion[this.persona.getY() - 1][this.persona.getX() - 1] = '+';
		}else{
			representacion[this.persona.getY() - 1][this.persona.getX() - 1] = '@';
		}
		
		return representacion;
	}

	public boolean estaLibre(int x, int y) {
		boolean libre = true;
		for (Pared item : this.paredes){
			if (item.ocupaLugar() && item.getX() == x && item.getY() == y){
				libre = false;
			}
		}
		
		for (Caja item : this.cajas){
			if (item.ocupaLugar() && item.getX() == x && item.getY() == y){
				libre = false;
			}
		}
		return libre;
	}

	public boolean todosLosDestinosOcupados(){
		boolean todos_ocupados = true;
		for (Destino destino: this.destinos){
			boolean destino_ocupado = false;
			
			for (Caja caja : this.cajas){
				if (destino.getX() == caja.getX() && destino.getY() == caja.getY()){
					destino_ocupado = true;
				}	
			}
			
			todos_ocupados = todos_ocupados && destino_ocupado;
		}
	      
	    
	    return todos_ocupados;
	}

	public ArrayList<Caja> getCajas() {
		return this.cajas;
	}

	public boolean itemPuedeMoverseDesdeHastaPosicion(int x_desde, int y_desde, int x_hasta, int y_hasta) {
		boolean puede_moverse = this.estaLibre(x_hasta, y_hasta);
		
		for (Pared item : this.paredes){
			if (item.getX() == x_desde && item.getY() == y_desde){
				puede_moverse = puede_moverse && item.movible();
			}
		}
		
		for (Caja item : this.cajas){
			if (item.getX() == x_desde && item.getY() == y_desde){
				puede_moverse = puede_moverse && item.movible();
			}
		}
		
		return puede_moverse;
	}

	public Persona getPersona() {
		return this.persona;
	}
	
	public Historia getHistoria(){
		return this.historia;
	}

	public void deshacer() {
		this.historia.deshacer();
	}
	
}
