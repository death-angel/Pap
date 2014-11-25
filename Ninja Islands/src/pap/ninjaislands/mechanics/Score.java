package pap.ninjaislands.mechanics;

public class Score {
	
	public static int score = 0;
	public int score_per_level = 40;
	
	public static int getScore(){
		return score;
	}
	
	public int getLevel(){
		if(getScore()/score_per_level < 1) return 1; 
		return getScore() / score_per_level;
	}
	
}
