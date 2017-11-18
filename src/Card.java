public class Card {

protected String suit;
protected int value;
protected String color;

public Card(String suit, int value){
	this.suit = suit;
	this.value = value;
	if(suit == "Spades" || suit == "Clubs")
		color = "Black";
	else
		color = "Red";
}
// Test
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
	return "Suit = " + suit + ", value = " + value + ", color = " + color + "\n";
}

}