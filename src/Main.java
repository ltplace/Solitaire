import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	protected static ArrayList<Tableau> Tabs;
	protected static ArrayList<Foundation> Fnds;
	protected static Deck deck;
	protected static WastePile WP;
	
	public Main() {
		
		// Instantiate Variables
		Tabs = new ArrayList<>();
		Fnds = new ArrayList<>();
		deck = new Deck();
		WP = new WastePile();
		
		// Create Tableaus and Foundations
		Tableau T;
		Foundation F;
		for(int i = 0; i < 7; i++) {
			Tabs.add(T = new Tableau());
		}
		for(int i = 0; i < 4; i++) {
			Fnds.add(F = new Foundation());
		}
		
		// Adds all Cards to each Tableau
		int card = 0;
		for(int j = 0; j < 7; j++) {
			for(int i = 0; i < j+1; i++) {
				Tabs.get(j).push(deck.removeFront());
				card++;
			}
		}
		
		// Make ends of each Tableau face-up (First playable card in each column) and grabbable
		for(int i = 0; i < 7; i++) {
			Tabs.get(i).top().faceUp(true);
			Tabs.get(i).top().grabbable = true;
		}
		
		// Place one card in WastePile
		moveToWastePile();
		
	}
	
	// Method that checks for valid moves between Tableaus
	public static boolean TabMoveChecker(int origTab, int index, int newTab) {
		
		// Check to see if move is valid for multiple cards
		boolean flag = isGrabbable(origTab, index);
		if (flag == false) return false;
		
		// Send to Tableau class to see if it can be added
		boolean valid = Tabs.get(newTab).addTo(Tabs.get(origTab).get(index));
		if (valid == true) {
			while (true) {
				if (Tabs.get(origTab).get(index) == Tabs.get(origTab).top()) {	// If current place in Tableau is top
					Tabs.get(newTab).push(Tabs.get(origTab).pop());
					Tabs.get(newTab).setGrabbable();
					if (!Tabs.get(origTab).isMT()) {	// If Tableau is empty
						Tabs.get(origTab).top().faceUp(true);
						Tabs.get(origTab).top().grabbable = true;
						break;
					}
					else {
						break;
					}
				}
				else {
					Tabs.get(newTab).push(Tabs.get(origTab).remove(index)); // Continue to move each card moved
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	// Method that checks for valid moves between WastePile and Foundation
	public static void WPtoFndChecker(int fnd) {
		boolean valid = Fnds.get(fnd).addTo(WP.top());
		if (valid == true) {
			WP.pop();
			if (WP.isFull()) {
				WP.top().faceUp(true);
				WP.top().grabbable = true;
			}
			else {
				moveToWastePile();
			}
		}
	}
	
	// Method that checks for valid moves between Tableaus and WastePile
	public static void WPtoTabChecker(int Tab) {
		boolean valid = Tabs.get(Tab).addTo(WP.top());
		if (valid == true) {
			Tabs.get(Tab).push(WP.pop());
			Tabs.get(Tab).setGrabbable();
			if (WP.isMT()) {
				moveToWastePile();
			}
			else {
			WP.top().faceUp(true);
			WP.top().grabbable = true;
			}
		}
	}
	
	// Method that checks for valid moves from Tableaus to Foundations
	public static boolean FndMoveChecker(int tab, int fnd) {
		boolean valid = Fnds.get(fnd).addTo(Tabs.get(tab).top()); // Sends to Tableau
		if (valid == true) {
			Tabs.get(tab).pop();
			if (!Tabs.get(tab).isMT()) {
				Tabs.get(tab).top().faceUp(true);
				Tabs.get(tab).top().grabbable = true;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	// Method that move cards from Deck to WastePile
	public static void moveToWastePile() {
		try {
			// If empty, push to WastePile from deck, make it face-up, and make it grabbable
			if (WP.isMT()) {
				WP.push(deck.removeFront());
				WP.top().faceUp(true);
				WP.top().grabbable = true;
			}
			// If not empty, make current top face-down and ungrabbable, then add new card
			else {
				WP.top().faceUp(false);
				WP.top().grabbable = false;
				WP.push(deck.removeFront());
				WP.top().faceUp(true);
				WP.top().grabbable = true;
			}
			// Catches when Deck is empty
		} catch(IndexOutOfBoundsException ex) {
			// Replace Cards from WastePile to their original order in Deck
			while(!WP.isMT()) {
				deck.add2Rear(WP.pop());
			}
		}
	}
	
	// Checks if card(s) is/are grabbable
	public static boolean isGrabbable(int origTab, int index) {
		boolean flag = true;
		for(int i = index; i < Tabs.get(origTab).size(); i++) {
			if (Tabs.get(origTab).get(i).grabbable == false) {	// this card and all cards being moved must be grabbable
				flag = false;									// If not, move cannot be made
			}
		}
		
		return flag;
	}


	
	
	
// Excess Testing Code
		
		// Visual Rep
	public static void print() {
		for(int i = 0; i < 7; i++) {
			System.out.println(i + " " + Tabs.get(i));
		}
		System.out.println("    0     1     2     3     4     5     6  \n");
		for(int i = 0; i < 4; i++) {
			System.out.println("Foundation " + i + ": " + Fnds.get(i));
		}
		System.out.println();
		System.out.println("WastePile: " + WP.top());
		String status = deck.isFullQ() ? "Full" : "Empty";
		System.out.println("Deck: " + status);
		System.out.println();
	}
}
		


