import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
	public static int count;
	public static Deck decks;
	public static ArrayList<Player> players;
	public static Player dealer;
	public static Scanner key = new Scanner(System.in);
	
	public static void main(String[] args) {
		count = 0;
		players = new ArrayList<Player>();
		decks = new Deck();
		divider();
		System.out.println("Welcome to the BlackJack table!");
		menu();
		divider();
	}
	
	public static void menu() {
		int choice = 0;
		int temp = 0;
		boolean loop = true;
		do {
			boolean skip = false;
			System.out.println("Please choose an option from below:");
			if (players.size() == 0) {
				System.out.println("(1) Add a player\n(2) House Rules"
									+ "\n(3) Exit");
				divider();
				try {
					choice = key.nextInt();
				}
				catch (Exception e) {
					key.next();
					skip = true;
					System.out.println("Sorry, invalid input");
				}
				if (!skip) {
					switch (choice) {
						case 1:	System.out.println("What is your name?");
								divider();
								temp = add(key.next());
								break;
						case 2: rules();
								break;
						case 3:	System.out.println("Thanks for playing!");
								loop = false;
								break;
						default:
								System.out.println("Sorry, invalid input");	
					}
				}
			}				
			else if (players.size() == 5) {
				System.out.println("(1) Remove a player\n(2) Start a Round"
									+ "\n(3) House Rules\n(4) Exit");
				divider();
				try {
					choice = key.nextInt();
				}
				catch (Exception e) {
					key.next();
					skip = true;
					System.out.println("Sorry, invalid input");
				}
				if (!skip) {
					switch (choice) {
						case 1:	System.out.println("Who is leaving?");
								divider();
								temp = remove(key.next());
								break;
						case 2:	start();
								break;
						case 3: rules();
								break;
						case 4:	System.out.println("Thanks for playing!");
								loop = false;
								break;
						default:
								System.out.println("Sorry, invalid input");	
					}
				}
			}
			else {
				System.out.println("(1) Add a player\n(2) Remove a player\n(3) Start a Round"
									+ "\n(4) House Rules\n(5) Exit");
				divider();
				try {
					choice = key.nextInt();
				}
				catch (Exception e) {
					key.next();
					skip = true;
					System.out.println("Sorry, invalid input");
				}
				if (!skip) {
					switch (choice) {
						case 1:	System.out.println("What is your name?");
								divider();
								temp = add(key.next());
								break;
						case 2:	System.out.println("Who is leaving?");
								divider();
								temp = remove(key.next());
								break;
						case 3:	start();
								break;
						case 4: rules();
								break;
						case 5:	System.out.println("Thanks for playing!");
								loop = false;
								break;
						default:
								System.out.println("Sorry, invalid input");	
					}
				}
			}
		} while (loop);
	}
	
	public static void divider() {
		System.out.println("----------------------------------------");
	}
	
	public static void rules() {
		divider();
		System.out.println("HOUSE RULES\n\t~ 6 Decks\n\t~ 1-5 Players\n\t~ $5 minimum bet"
							+ "\n\t~ BlackJack pays 3:2\n\t~ Dealer hits on soft 17"
							+ "\n\t~ Double down after splitting is allowed"
							+ "\n\t~ No re-splitting Aces\n\t~ Surrendering is Permitted"
							+ "\n\t~ Insurance bet less than or equal to half initial bet"
							+ "\n\t  and pays 2:1\n\t~ Even money is permitted");
		divider();
	}
	
	public static int add(String n) {
		for (Player p : players) {
			if (p.name.equals(n)) {
				System.out.println("Sorry, someone is already using this name!");
				return 0;
			}
		}
		Player toAdd = new Player(n);
		toAdd.buy();
		players.add(toAdd);
		count = players.size();
		return 1;
	}
	
	public static int remove(String n) {
		for (Player p : players) {
			if (p.name.equals(n)) {
				players.remove(p);
				count = players.size();
				return 0;
			}
		}
		System.out.println("Sorry, that player is not at the table!");
		return 1;
	}
	
	public static void start() {
		dealer = new Player("Dealer");
		decks = new Deck();
		for (Player p : players)
			p.bet();
		for (int i = 0; i <= 1; i++) {
			for (Player p : players) {
				p.hand.add(decks.remove((int)(Math.random()*decks.size())));
			}
			dealer.hand.add(decks.remove((int)(Math.random()*decks.size())));
		}
		for (Player p : players) {
			p.show();
		}
		
	}
}