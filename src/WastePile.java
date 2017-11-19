import java.util.ArrayList;

public class WastePile implements Stack<Card>{

	protected ArrayList<Card> array = new ArrayList<>();
	
	
	@Override
	public String toString() {
		return array.toString();
	}

	@Override
	public void push(Card card) {
		array.add(0, card);
	}

	@Override
	public Card pop() {
		Card retval = null;
		if(!isMT()){
		retval = array.remove(0);
		}else{
			System.out.println("Can't remove from empty stack");
		}
		return retval;
	}

	@Override
	public Card top() {
		Card retval = null;
		if(!isMT()){
		retval = array.get(0);
		}else{
			System.out.println("Can't get from empty stack");
		}
		return retval;
	}

	@Override
	public boolean isMT() {
		boolean retval = true;
		if(array.size() > 0){
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	// Method that removes from back to place back in Deck
	public Card removeBack() {
		Card card = null;
		if (!isMT()) {
			card = array.remove(array.size()-1);
		}
		return card;
	}

}
