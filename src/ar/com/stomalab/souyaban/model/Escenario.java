package ar.com.stomalab.souyaban.model;

import java.util.ArrayList;

public class Escenario {
	private ArrayList<Destino> destinos;
	private ArrayList<Pared> paredes;
	private ArrayList<Caja> cajas;
		
	private Persona persona;
		
	public Escenario()
	{
		this.destinos = new ArrayList<Destino>();
		this.paredes = new ArrayList<Pared>();
		this.cajas = new ArrayList<Caja>();
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
	
}
