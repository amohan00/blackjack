import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
	
	public String name;
	public int bank;
	public int bet;
	public ArrayList<Integer> hand;
	String card1;
	String card2;
	public boolean bust;
	public boolean bj;
	public boolean split;
	public boolean ace;
	
	
	public Player(String n) {
		name = n;
		bank = 0;
		bet = 0;
		hand = new ArrayList<Integer>();
		card1 = " ";
		card2 = " ";
		bust = false;
		bj = false;
		split = false;
		ace = false;
	}
	
	public void bet() {
		int total = 0;
		Scanner key = new Scanner(System.in);
		while (true) {
			System.out.printf("%s: How much would you like to bet?\n", this.name);
			divider();
			try {
				total = key.nextInt();
				if (total <= 0 || total > this.bank)
					System.out.println("Sorry, illegal bet");
				else {
					bank -= total;
					bet = total;
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Sorry, illegal bet");
				key.next();
			}
		}	
	}
	
	public void buy() {
		int total = 0;
		Scanner key = new Scanner(System.in);
		while (true) {
			System.out.println("How much would you like to buy-in?");
			divider();
			try {
				total = key.nextInt();
				if (total <= 0)
					System.out.println("Sorry, illegal buy-in");
				else {
					bank += total;
					break;
				}
			}
			catch (Exception e) {
				System.out.println("SOrry, illegal buy-in");
				key.next();
			}
		}			
	}

	public String toString() {
		return this.name;
	}
	
	public void show() {
		if (this.hand.get(0) <= 10 && this.hand.get(0) != 1)
				this.card1 = Integer.toString(this.hand.get(0));
		else {
			switch(this.hand.get(0)) {
				case 1: this.card1 = "Ace";
						break;
				case 11: this.card1 = "Jack";
						break;
				case 12: this.card1 = "Queen";
						break;
				case 13: this.card1 = "King";
						break;
			}
		}
		if (this.hand.get(1) <= 10 && this.hand.get(1) != 1)
				this.card2 = Integer.toString(this.hand.get(1));
		else {
			switch(this.hand.get(1)) {
				case 1: this.card2 = "Ace";
						break;
				case 11: this.card2 = "Jack";
						break;
				case 12: this.card2 = "Queen";
						break;
				case 13: this.card2 = "King";
						break;
			}
		}
		System.out.println(this.card1 + ", " + this.card2);
	}
	
	public static void divider() {
		System.out.println("----------------------------------------");
	}
}