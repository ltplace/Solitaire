import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class Tableau implements Stack<Card> {

	protected ArrayList<Card> Column = new ArrayList<Card>();

	public void addTo(Card card) {
		if (card.color != Column.get(0).color && card.value == Column.get(0).value - 1) {
			push(card);
		}
		setGrabbable();
	}	
	// May not need for end product
	public Card get(int index) {
		return Column.get(index);
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

		if(Column.size() > 0){
			retval = false;
		}
		return retval;
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	@Override
	public String toString() {
		return Column.toString();
	}
	
	public void setGrabbable(){
		Column.get(0).grabbable = true;
		try{
			for(int i=0; i<Column.size(); i++){
				if(Column.get(i).color != Column.get(i+1).color && Column.get(i).value == Column.get(i+1).value -1){
					Column.get(i+1).grabbable = true;
				}
				else{
					return;
				}
			}
		}catch(IndexOutOfBoundsException e){
		}
	}
}