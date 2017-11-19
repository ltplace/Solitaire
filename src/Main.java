import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Variables
		Deck deck = new Deck();
		WastePile WP = new WastePile();
	
		Tableau T1 = new Tableau();
		Tableau T2 = new Tableau();
		Tableau T3 = new Tableau();
		Tableau T4 = new Tableau();
		Tableau T5 = new Tableau();
		Tableau T6 = new Tableau();
		Tableau T7 = new Tableau();
		ArrayList<Tableau> Tabs = new ArrayList<>();
		Tabs.add(T1);
		Tabs.add(T2);
		Tabs.add(T3);
		Tabs.add(T4);
		Tabs.add(T5);
		Tabs.add(T6);
		Tabs.add(T7);
		
		// Adds all Cards to each Tableau
		int card = 0;
		for(int j = 0; j < 7; j++) {
			for(int i = 0; i < j+1; i++) {
				Tabs.get(j).push(deck.get(card));
				card++;
			}
		}
	
		System.out.println(T1);
		System.out.println(T2);
		T1.addTo(T2.get(1));
		System.out.println(T1);
		System.out.println(T2);
		
		// Adds deck to Wastepile (Make this into function; Remove lines until you reach try block.
		while(true) {
			System.out.println(deck);
			System.out.println("Next card? ");
			int input = sc.nextInt();
			
			if (input == 1) {
				try {
					WP.add2Rear(deck.removeFront());
				} catch(IndexOutOfBoundsException ex) {
					while(!WP.isMTQ()) {
						deck.add2Rear(WP.removeFront());
					}
				}
			}
			System.out.println(WP);
		}
		
		// Visual Rep
		/*
		for(int j = 0; j < 7; j++) {
			for(int i = 0; i < 7; i++) {
				try {
					System.out.print(Tabs.get(i).get(j) + " ");
				} catch(IndexOutOfBoundsException ex) {
						System.out.print("   ");
					continue;
				}
			}
			System.out.println();
		}
		*/
	}
}
