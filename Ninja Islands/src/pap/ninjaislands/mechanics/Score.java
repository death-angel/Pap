package pap.ninjaislands.mechanics;

public class Score {
	
	public static int score = 0;
	public static int score_per_level = 30;
	
	public static int currentSuperAttack = 0;
	public static int maxSuperAttack = 2;
	
	public static int getScore(){
		return score;
	}
	
	public static int getLevel(){
		if(getScore()/score_per_level < 1) return 1; 
		return getScore() / score_per_level;
	}
	
}
