import java.util.ArrayList;

public class Tableau implements Stack<Card>{
	
	protected ArrayList<Card> Column = new ArrayList<Card>();
	private Card top = Column.get(Column.size() - 1);
	
	
	
	public void addTo(Card card) {
		
		
	}
	
	
	
	public Card topOfTablue() {
		return Column.get(0);
	}
	
	
}
