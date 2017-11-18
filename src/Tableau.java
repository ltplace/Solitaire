import java.util.ArrayList;

public class Tableau {
	
	protected ArrayList<Card> Column = new ArrayList<Card>();
	
	
	public Card topOfTablue() {
		return Column.get(0);
	}
	
	
}
