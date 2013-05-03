package ar.com.stomalab.souyaban.model;

import java.util.HashMap;

public class Highscore {
	private HashMap<String, HashMap<Integer, Integer> > highscore;
	
	public Highscore() {
		this.highscore = new HashMap<String, HashMap<Integer, Integer> >();
	}
	
	public void setHighscore(String levelset, int nivel, int movimientos){
		HashMap<Integer, Integer> highscore_para_este_levelset;
		if (!this.highscore.containsKey(levelset)){
			highscore_para_este_levelset = new HashMap<Integer, Integer>(); 
			this.highscore.put(levelset, highscore_para_este_levelset);
		}
		else
		{
			highscore_para_este_levelset = this.highscore.get(levelset);
		}
		
		if (!highscore_para_este_levelset.containsKey(Integer.valueOf(nivel))){
			highscore_para_este_levelset.put(Integer.valueOf(nivel), Integer.valueOf(movimientos));
		}
		else
		{
			if (Integer.valueOf(movimientos) > highscore_para_este_levelset.get(Integer.valueOf(nivel))){
				highscore_para_este_levelset.put(Integer.valueOf(nivel), Integer.valueOf(movimientos));
			}
		}
	}
	
	public HashMap<String, HashMap<Integer, Integer> > getHighscoreCompleto(){
		return this.highscore;
	}
	
}
