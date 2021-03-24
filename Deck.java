import java.util.ArrayList;

public class Deck {
	
	public ArrayList<Integer> cards;
	
	public Deck() {
		cards = new ArrayList<Integer>();
		for (int h = 0; h < 6; h++) {
			for (int i = 1; i < 14; i++) {
				for (int j = 0; j < 4; j++)
					cards.add(i);
			}
		}
	}
	
	public String toString() {
		return this.cards.toString();
	}
	
	// removes and outputs a card from the deck
	public int remove(int index) {
		int ret = this.cards.get(index);
		this.cards.remove(index);
		return ret;
	}
	
	public int size() {
		return this.cards.size();
	}
	
	public static void main(String[] args) {
		Deck test = new Deck();
		System.out.println(test);
		System.out.println(test.remove(10));
		System.out.println(test);
		System.out.println(test.cards.size());
	}
}