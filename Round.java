import java.util.ArrayList;
import java.util.Scanner;


public class Round {
	public ArrayList<Player> players;
	public int count;
	
	public Round(ArrayList<Player> play) {
		players = play;
		count = players.size();
	}
	
	public static void main(String[] args) {
		ArrayList<Player> test = new ArrayList<Player>();
		Round round = new Round(test);
	}
}