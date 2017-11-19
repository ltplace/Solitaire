import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

public class Deck implements Queue<Card>{

	protected static ArrayList<Card> deck;

	public Deck (){

		deck = new ArrayList<Card>();

		final String[] setSuit = new String[] { "C", "S", "H", "D" };

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card(setSuit[i], j);
				// Adds Club card images
				if (i == 0) {
					try {
						card.FaceImg = ImageIO.read(new File("Deck//" + j + "_of_clubs.png"));
						card.resize(card.FaceImg, 20, 40);
					} catch (IOException e) {}
				}
				// Adds Spades card images
				if (i == 1) {
					try {
						card.FaceImg = ImageIO.read(new File("Deck//" + j + "_of_spades.png"));
						card.resize(card.FaceImg, 20, 40);
					} catch (IOException e) {}
				}
				// Adds Hearts card images
				if (i == 2) {
					try {
						card.FaceImg = ImageIO.read(new File("Deck//" + j + "_of_hearts.png"));
						card.resize(card.FaceImg, 20, 40);
					} catch (IOException e) {}
				}
				// Adds Diamonds card images
				if (i == 3) {
					try {
						card.FaceImg = ImageIO.read(new File("Deck//" + j + "_of_diamonds.png"));
						card.resize(card.FaceImg, 20, 40);
					} catch (IOException e) {}
				}
				// Add to deck
				deck.add(card);
			}
		}
		// Shuffle entire deck
		shuffle();
	}

	// Method to shuffle entire deck
	public void shuffle()
	{
		Random rnd = ThreadLocalRandom.current();
		for (int i = 51; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Card a = deck.get(index);
			deck.set(index, deck.get(i));
			deck.set(i, a);
		}
	}

	@Override
	public void add2Rear(Card card) {
		deck.add(card);
	}

	// Added ability to remove from the front (like a Stack)
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
