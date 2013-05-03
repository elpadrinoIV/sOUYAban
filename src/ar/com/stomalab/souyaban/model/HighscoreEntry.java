package ar.com.stomalab.souyaban.model;

public class HighscoreEntry {
	private long id;
	private String levelset;
	private int nivel;
	private int movimientos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLevelset() {
		return levelset;
	}
	public void setLevelset(String levelset) {
		this.levelset = levelset;
	}	
	
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	
}
