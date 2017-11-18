import java.util.ArrayList;

public class Tableau implements Stack<Card> {

	protected ArrayList<Card> Column = new ArrayList<Card>();

	public void addTo(Card card) {
		if (card.color != Column.get(0).color && card.value == Column.get(0).value - 1) {
			push(card);
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
		}else{
			System.out.println("Can't remove from empty stack");
		}
		return retval;
	}

	@Override
	public Card top() {
		Card retval = null;
		if(!isMT()){
		retval = arr.get(0);
		}else{
			System.out.println("Can't get from empty stack");
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
		return false;
	}
}
