
public interface Stack <Card> {

	void push(Card car);//Adds value to start of stack
	
	Card pop();//Removes value from top of stack
	
	Card top();//Returns value from top but doesn't remove value
	
	boolean isMT();//Checks to see if Stack is empty
	
	boolean isFull();//Checks to see if Stack is full
	
}
