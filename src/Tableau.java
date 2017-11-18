import java.util.ArrayList;

public class Tableau implements Stack<Card> {

	protected ArrayList<Card> Column = new ArrayList<Card>();

	public void addTo(Card card) {
		if (card.color != Column.get(0).color && card.value == Column.get(0).value - 1) {
			push(card);
		}
	}

	public Card topOfTablue() {
		return Column.get(0);
	}

	@Override
	public void push(Card car) {
		Column.add(0, car);
	}

	@Override
	public Card pop() {
		Card retval = null;
		if (!isMT()) {
			retval = Column.remove(0);
		}
		return retval;
	}

	@Override
	public Card top() {
		Card retval = null;
		if (!isMT()) {
			retval = Column.get(0);
		}
		return retval;
	}

	@Override
	public boolean isMT() {
		boolean retval = true;
		if (Column.size() > 0) {
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
