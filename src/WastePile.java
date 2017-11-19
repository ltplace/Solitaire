import java.util.ArrayList;

public class WastePile implements Queue<Card>{

	protected ArrayList<Card> array = new ArrayList<>();
	
	@Override
	public void add2Rear(Card ch) {
		array.add(ch);
	}

	@Override
	public Card removeFront() {
		Card retval = null;
		if (array.size() > 0) {
			retval = array.remove(0);
		}
		
		return retval;
	}

	@Override
	public Card examineFront() {
		Card retval = null;
		if (!isMTQ()) {
			retval = (Card) array.get(0);
		}
		return retval;
	}

	@Override
	public boolean isMTQ() {
		boolean retval = true;
		if (array.size() > 0) {
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFullQ() {
		boolean retval = false;
		if (array.size() > 0) {
			retval = true;
		}
		return retval;
	}
	
	@Override
	public String toString() {
		return array.toString();
	}
}
