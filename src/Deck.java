import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {	
	
public static ArrayList<Card> getDeck(){

	ArrayList<Card> deck = new ArrayList<Card>();

	final String[] setSuit = new String[] { "C", "S", "H", "D" };

	for (int i = 0; i < 4; i++) {
		for (int j = 1; j <= 13; j++) {
			Card card = new Card(setSuit[i], j);
			deck.add(card);
		}
	}
	shuffle(deck);

	return deck;
}

static void shuffle(ArrayList<Card> deck)
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

}