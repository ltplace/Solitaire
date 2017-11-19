import java.util.ArrayList;

public class Foundation implements Stack<Card> {

	ArrayList<Card> arr = new ArrayList<>();
	
	//Pushes Card onto Stack if requirements are met
	public boolean addTo(Card card) {
		// If foundation is empty and card is an Ace, push to this Foundation
		if (arr.isEmpty()) {
			if (card.value == 1 || card.value == 14 || card.value == 27 || card.value == 40) {
				push(card);
				return true;
				}
			else {
				return false;
			}
		}
		// Check for if foundation already has cards in place
		else if ((top().suit.equals(card.suit) && top().value == card.value - 1)) {
			push(card);
			return true;
		}
		// If foundation is empty and card is an Ace, push to this Foundation
		else if (arr.isEmpty() && (card.value == 1 || card.value == 14 || card.value == 27 || card.value == 40)) {
			push(card);
			return true;
		}
		// Cannot move to here
		else {
			return false;
		}
	}

	@Override
	public void push(Card card) {
		arr.add(0, card);
	}

	@Override
	public Card pop() {
		Card retval = null;
		if(!isMT()){
			retval = arr.remove(0);
		}
		
		return retval;
	}

	@Override
	public Card top() {
		Card retval = null;
		if(!isMT()){
			retval = arr.get(0);
		}
		
		return retval;
	}

	@Override
	public boolean isMT() {
		boolean retval = true;
		if(arr.size() > 0){
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFull() {
		if(arr.size() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return arr.toString();
	}

}
