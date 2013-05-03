package ar.com.stomalab.souyaban.model;

import java.util.ArrayList;

import android.util.SparseArray;

public class Levelset {
	private SparseArray<ArrayList<String> > niveles;
	private String nombre;
	
	public Levelset(){
		niveles = new SparseArray<ArrayList<String> >();
	}
	
	public void agregarNivel(int numero_nivel, ArrayList<String> nivel){
		niveles.put(Integer.valueOf(numero_nivel), nivel);
	}
	
	public ArrayList<String> getNivel(int numero_nivel){
		return niveles.get(Integer.valueOf(numero_nivel));
	}
	
	public void cargarLevelsetDesdeArchivo(String archivo){
		// TODO
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
