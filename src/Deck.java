import java.util.Random;

public class Deck {

	protected int cards_left;
	protected Card Cards[];
	protected int number_of_cards;

	public Deck() {

		Cards = new Card[57];
		reintializeDeck();
	}

	public void shuffle() {
		Random rand = new Random();
		int n = rand.nextInt(57);
		int g = rand.nextInt(57);
		for (int i = 1; i < 100; i++) {
			n = rand.nextInt(57);
			g = rand.nextInt(57);
			Card j;
			j = Cards[g];
			Cards[g] = Cards[n];
			Cards[n] = j;

		}
	}
	private void reintializeDeck() {
		
		for (int i = 0; i < 56; i++) {
			Card n = new Card(i+1);
			Cards[i] = n;
		}
		cards_left = 56;
		shuffle();
	}
	public Card PickCard() {
		if(number_of_cards==0) {
			reintializeDeck();
		}
		
		Card curr = Cards[0];
		Cards[1] = Cards[cards_left];
		cards_left--;
		
		return curr;
	}

}
