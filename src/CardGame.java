import java.util.Scanner;

public class CardGame {
	private Deck d = new Deck();
	private Player[] players;
	public CardGame(int numberofplayers) {
		
		players = new Player [numberofplayers];
		for(int i=0;i<numberofplayers;i++) {
			players[i]= new Player(i);
		}
		
	}
	public void Game() {
		while(!isGameOver()) {
			Round();
		}
	}
	
	public  boolean isGameOver() {
		int maxscore = players[0].getScore();
		int maxindex = 0;
				
		for(int i=1;i<players.length;i++) {
			int score = players[i].getScore();
			if(score >maxscore) {
				maxscore = score;
				maxindex = i;
			}
		}
		if(maxscore <21) {
			return false;
		}
		for(int j=0;j<players.length;j++) {
			if(j!=maxindex) {
				if(Math.abs(players[j].getScore()-maxscore ) ==1)
					return false;
			}
		}
		System.out.println("player " + maxindex +  " wins!" );
		return true;
	}
	
	public void Round() {
		
		Card [] roundcards = new Card[players.length];
		for(int i=0;i<players.length;i++) {
			System.out.println("player " + i + "'s turn:");
			System.out.println("Player " + i  + " press enter.");
			Scanner input= new Scanner(System.in);
			String readString ="";
			
			 if (input.hasNextLine())
			      readString = input.nextLine();
			
			roundcards[i] = d.PickCard();
			System.out.println("Player " + i +" picks " +roundcards[i].toString()+".");
		}
		
		Card max = roundcards[0];
		int maxindex = 0;
		if(max.isPenaltyCard()) {
			players[0].setScore(-1);
		}
				
		for(int i=1;i<roundcards.length;i++) {
			if(roundcards[i].isPenaltyCard()) {
				players[i].setScore(-1);
			}
			if(roundcards[i].compareTo(max)==1) {
				max = roundcards[i];
				maxindex = i;
				
			}
		}
		
		players[maxindex].setScore(2);
		for(int i=0;i<players.length;i++) {
			System.out.println(players[i].toString());
		}
		
		
	}
}
