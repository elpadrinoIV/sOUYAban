package ar.com.stomalab.souyaban.model;

import java.util.ArrayList;

public class Historia {
	private enum Estado { COMENZADO, TERMINADO }
	private enum Quien { PERSONA, CAJA }
	
	ArrayList<ArrayList<ArrayList<Object> > > historia;
	Estado estado_evento;
	ArrayList<ArrayList<Object> > evento_actual;
	
	
	public Historia(){
		this.historia = new ArrayList<ArrayList<ArrayList<Object> > >();
		this.estado_evento = Estado.TERMINADO;
	}
	
	public void empezarEvento(){
		this.estado_evento = Estado.COMENZADO;
		this.evento_actual = new ArrayList<ArrayList<Object> >();
	}
	
	public void terminarEvento(){
	  this.estado_evento = Estado.TERMINADO;

	  if (0 != this.evento_actual.size()){
		  this.historia.add(this.evento_actual);  
	  }
	}
	
	public void personaSeMovio(Persona persona, int desde_x, int desde_y, int hasta_x, int hasta_y){
		if (Estado.COMENZADO == this.estado_evento)
		{
			ArrayList<Object> accion_evento = new ArrayList<Object>();
			accion_evento.add(Quien.PERSONA);
		    accion_evento.add(persona);
		    accion_evento.add(new Integer(desde_x));
		    accion_evento.add(new Integer(desde_y));
		    accion_evento.add(new Integer(hasta_x));
		    accion_evento.add(new Integer(hasta_y));
		    
		    this.evento_actual.add(accion_evento);

		}
	}
	
	public void cajaSeMovio(Caja caja, int desde_x, int desde_y, int hasta_x, int hasta_y){
		if (Estado.COMENZADO == this.estado_evento)
		{
			ArrayList<Object> accion_evento = new ArrayList<Object>();
			accion_evento.add(Quien.CAJA);
		    accion_evento.add(caja);
		    accion_evento.add(new Integer(desde_x));
		    accion_evento.add(new Integer(desde_y));
		    accion_evento.add(new Integer(hasta_x));
		    accion_evento.add(new Integer(hasta_y));
		    
		    this.evento_actual.add(accion_evento);

		}
	}
	
	public void deshacer(){
		if (this.historia.size() > 0){
			ArrayList<ArrayList<Object> > evento = this.historia.remove(this.historia.size() - 1);
			
			if (null != evento){
				for (ArrayList<Object> accion_evento : evento){
					Quien quien = (Quien) accion_evento.get(0);
					Item item = (Item) accion_evento.get(1);
					int desde_x = (Integer) accion_evento.get(2);
					int desde_y = (Integer) accion_evento.get(3);
					
					switch (quien){
					case PERSONA:
						item.setPosicion(desde_x, desde_y);
						// item.cambiar_cantidad_movimientos(item.get_cantidad_movimientos - 1)
						break;
					case CAJA:
						System.out.println("Desahcer caja desde (" + desde_x + ", "+ desde_y + ")");
						item.setPosicion(desde_x, desde_y);
						break;
					default:
						break;
					}
				}
			}
		}
	}
}
