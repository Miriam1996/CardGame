
public class Player {
	private int score;
	private int playerid;
	Player(int playerid){
		this.playerid = playerid;
		score = 0;
	}
	
	public int getScore() {
		return score;
		
	}
	
	public void setScore(int points) {
		score+=points;
	}
	public String toString() {
		return "player " + playerid + ": score is " + score + ".";
		
	}
	
}
