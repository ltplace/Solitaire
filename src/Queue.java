public interface Queue<Card> {

	void add2Rear(Card card);	//Adds to back of Queue
	
	Card removeFront();		//Removes first number in Queue
	
	Card examineFront();		//Shows number in first part of Queue
	
	boolean isMTQ();		//Shows if Queue is empty
		
	boolean isFullQ();		//Shows if Queue is full
}	
