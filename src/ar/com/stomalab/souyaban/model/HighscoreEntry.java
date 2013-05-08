package ar.com.stomalab.souyaban.model;

public class HighscoreEntry {
	private String levelset;
	private int nivel;
	private int movimientos;
	
	public HighscoreEntry(){	}
	
	public HighscoreEntry(String levelset, int nivel, int movimientos){
		this.levelset = levelset;
		this.nivel = nivel;
		this.movimientos = movimientos;
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
	
	@Override
	public String toString(){
		return this.levelset + " - " + Integer.toString(this.nivel) + ": " + Integer.toString(this.movimientos);
	}
}
