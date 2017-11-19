import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

	static ArrayList<Card> deck = new ArrayList<Card>();
public static void main(String[] args) {

	final String[] setSuit = new String[] { "Clubs", "Spades", "Hearts", "Diamonds" };

	for (int i = 0; i < 4; i++) {
		for (int j = 1; j <= 13; j++) {
			Card card = new Card(setSuit[i], j);
			deck.add(card);
		}
	}
	System.out.println(deck.toString());
	//shuffle(deck);
	System.out.println(deck.toString());

	}

	public void shuffle(ArrayList<Card> deck)
	  {
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = 51; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      Card a = deck.get(index);
	      deck.set(index, deck.get(i));
	      deck.set(i, a);
	    }
	  }

	public Card draw(){
		
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

}
