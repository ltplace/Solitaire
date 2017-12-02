import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Tableau implements Stack<Card> {

	protected ArrayList<Card> Column = new ArrayList<Card>();
	protected int space = 49;

	// Method for checking valid movements between Tableaus
	public boolean addTo(Card card) {
		if (Column.isEmpty()) {
			if (card.value == 13) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (card.color != Column.get(size()-1).color && card.value == Column.get(size()-1).value - 1) {
				return true;
			}
			else {
				return false;
			}
		}
	}	
	public int indexOf(int index) {
		index = Column.indexOf(index);
		return index;
	}
	
	// May not need for end product
	public Card get(int index) {
		return Column.get(index);
	}
	@Override
	public void push(Card car) {
		Column.add(car);
	}
	
	// Return size of Tableau
	public int size() {
		return Column.size();
	}

	@Override
	public Card pop() {
		Card retval = null;
		if (!isMT()) {
			retval = Column.remove(size()-1);
		}
		return retval;
	}
	
	// Method for removing in middle of stack
	public Card remove(int index) {
		Card retval = null;
		if (!isMT()) {
			retval = Column.remove(index);
		}
		return retval;
	}

	@Override
	public Card top() {
		Card retval = null;
		if (!isMT()) {
			retval = Column.get(size()-1);
		}
		return retval;
	}

	@Override
	public boolean isMT() {
		boolean retval = true;

		if(Column.size() > 0){
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFull() {
		if (Column.size() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return Column.toString();
	}
	
	public void setGrabbable(){
		Column.get(size()-1).grabbable = true;
		if (Column.size() != 1) {
			Column.get(size()-2).grabbable = true;
		}
		try{
			for(int i=size();; i++){
					Column.get(i).grabbable = true;
				}
		}catch(IndexOutOfBoundsException e){
		}
	}
}