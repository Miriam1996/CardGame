
public class Card {

	private int value;

	public Card(int v) {
		if (v < 0 || v > 57)
			throw new IllegalArgumentException("invalid value");
		value = v;
	}

	public String toString() {
		String s = "";
		// value of %13 =1 so card is Ace
		if (this.value % 13 == 1 && this.value <= 52)
			s += "A";
		// value of %13 11 so card is Jack
		else if (this.value % 13 == 11 && this.value <= 52)
			s += "J";
		else if (this.value % 13 == 12 && this.value <= 52)
			s += "Q";
		else if (this.value % 13 == 0 && this.value <= 52)
			s += "K";
		else
			s += this.value % 13;
		if (this.value >= 1 && this.value <= 13 && this.value <= 52)
			s += " Spade";
		else if (this.value >= 14 && this.value <= 26 && this.value <= 52)
			s += " Heart";
		else if (this.value >= 27 && this.value <= 39 && this.value <= 52)
			s += " Diamond";
		else if (this.value >= 40 && this.value <= 52 && this.value <= 52)
			s += " Club";

		if (this.value > 52) {
			return "penalty card";
		}
		return s;
	}

	public boolean isPenaltyCard() {
		return value >= 53;
	}

	public int compareTo(Card c) {
		// the card is a penalty card
		if (this.value >= 53 && c.value <= 52) {
			return -1;
		}

		// other card is penalty card
		else if (this.value <= 52 && c.value >= 53) {
			return 1;
		}
		// both penalty
		else if (this.value >= 53 && c.value >= 53) {
			return 0;
		}
		// other card is a and the other one isn't
		else if (this.value % 13 == 1 && c.value % 13 != 1) {
			return 1;
		} else if (this.value % 13 != 1 && c.value % 13 == 1) {
			return -1;
		}
		// both aces but higher suit value
		else if (this.value % 13 == 1 && c.value % 13 == 1&& this.value < c.value ) {
			return 1;
		}
		// both aces lower suite value
		else if (this.value % 13 == 1 && c.value % 13 == 1 && this.value > c.value)
			return -1;
		// higher card
		else if (this.value % 13 > c.value % 13) {
			return 1;
		}

		// lower card
		else if (this.value % 13 < c.value % 13 ) {
			return -1;
		}
		// same card but higher suite
		else if (this.value % 13 == c.value % 13 && this.value < c.value && this.value <= 52 && c.value <= 52) {
			return 1;
		}
		// same card lower suite value
		else if (this.value % 13 == c.value % 13 && this.value > c.value && this.value <= 52 && c.value <= 52)
			return -1;

		return 0;

	}
}
