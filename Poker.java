import java.util.ArrayList;
import java.util.Scanner;

public class Poker {
	
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		int count = 0;
		int pot = 0;
		Scanner key = new Scanner(System.in);
		
		System.out.println("Welcome to the poker table! How many players?");
		count = key.nextInt();
		Player newbie;
		// add players to the table
		for (int i = 1; i <= count; i++) {
			System.out.printf("Player %s, what is your name?\n", i);
			newbie = new Player(key.next());
			newbie.buy();
			players.add(newbie);
		}
		
	}
}