import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck implements Queue<Card>{	
	
	protected static ArrayList<Card> deck;
	
	public Deck(){

		deck = new ArrayList<Card>();

		final String[] setSuit = new String[] { "C", "S", "H", "D" };

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card(setSuit[i], j);
				deck.add(card);
			}
		}
		shuffle();
	}

	public void shuffle()
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
	
	public static Deck getDeck() {
		Deck deck = new Deck();
		return deck;
	}

	public Card get(int index) {
		return deck.get(index);
	}

	@Override
	public void add2Rear(Card card) {
		deck.add(card);
	}
	
	@Override
	public Card removeFront() {
		
		Card retval = deck.remove(0);
		
		return retval;
	}

	@Override
	public Card examineFront() {
		Card retval = null;
		if (!isMTQ()) {
			retval = (Card) deck.get(0);
		}
		return retval;
	}

	@Override
	public boolean isMTQ() {
		boolean retval = true;
		if (deck.size() > 0) {
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFullQ() {
		boolean retval = false;
		if (deck.size() > 0) {
			retval = true;
		}
		return retval;
	}
	
	@Override
	public String toString() {
		return deck.toString();
	}

}
