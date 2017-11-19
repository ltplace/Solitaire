public class Card {

	protected String suit;
	protected int value;
	protected String color;
	protected boolean faceDown = true;

	public Card(String suit, int value){
		this.suit = suit;
		this.value = value;
		if(suit == "S" || suit == "C")
			color = "Black";
		else
			color = "Red";
	}

	public void faceUp(boolean choice) {
		if (choice == false) {
			this.faceDown = false;
		}
		else {
			this.faceDown = true;
		}
	}

	private void compareTo(Card card1, Card card2){
		if(card1.color == "Black" && card2.color == "Red" && card2.value == card1.value + 1){
			//move is allowed
		}
		else if(card1.color == "Red" && card2.color == "Black" && card2.value == card1.value + 1){
			//Move is allowed
		}
		else{
			System.out.println("Move not allowed. Try another move.");
		}

	}

	public String toString(){
		return String.format("%s%s", suit, value);
	}
}

