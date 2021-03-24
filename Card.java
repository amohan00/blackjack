// Card class for poker program

public class Card {
	
	public int value;
	public int suit;
	public String toPrint;
	
	public Card() {
		value = (int)(Math.random()*13)+1;
		suit = (int)(Math.random()*4)+1;
		String s = " ";
		String c = " ";
		switch(suit) {
			case 1: s = "Clubs";
					break;
			case 2: s = "Spades";
					break;
			case 3: s = "Diamonds";
					break;
			case 4: s = "Hearts";
					break;
		}
		if (value <= 10 && value != 1)
			c = Integer.toString(value);
		else {
			switch(value) {
				case 1: c = "Ace";
						break;
				case 11: c = "Jack";
						break;
				case 12: c = "Queen";
						break;
				case 13: c = "King";
						break;
			}
		}
		toPrint = c+" of "+s;
	}
	
	public String toString() {
		return toPrint;
	}
	
	public int compValue(Card other) {
		// return 1 if this card is higher
		if (this.value > other.value)
			return 1;
		// 0 if it is equal
		else if (this.value == other.value)
			return 0;
		// -1 for less than
		else
			return -1;
	}
	
	public boolean compSuit(Card other) {
		if (this.suit == other.suit)
			return true;
		return false;
	}
}