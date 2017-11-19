import java.util.InputMismatchException;
import java.util.Scanner;

public class ModelOfGame extends Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Game_Viewer x = new Game_Viewer();
		
		/*
		while(true) {
			
		try{
			print();
			
			System.out.println("Grab from WastePile? ");
			String input = sc.next();
			if (input.equals("yes")) {
				System.out.println("Select which column (0-6): ");
				int col = sc.nextInt();
				WPtoTabChecker(col);
				continue;
			}
			
			System.out.println("Place a card in Foundation? ");
			input = sc.next();
			if (input.equals("yes")) {
				System.out.println("From where (wp or tab)? ");
				input = sc.next();
				if (input.equals("wp")) {
					System.out.println("Please enter a Foundation: ");
					int fnd = sc.nextInt();
					WPtoFndChecker(fnd);
					continue;
				}
				else {
					System.out.println("Please enter a Column and Foundation: ");
					int col = sc.nextInt();
					int fnd = sc.nextInt();
					FndMoveChecker(col, fnd);
					continue;
				}
			}
			System.out.println("Movements between columns? ");
			input = sc.next();
			if (input.equals("yes")) {
				System.out.println("Please select a column, index, and a new column: ");
				int origCol = sc.nextInt(); 
				int index = sc.nextInt();
				int newCol =sc.nextInt();
				TabMoveChecker(origCol, index, newCol);
				continue;
			}
			int count = 7;
			for (int i = 0; i < 7; i++) {
				if (Tabs.get(i).isMT()) {
					count--;
				}
			}
			if (count == 0) break;
			
			moveToWastePile();
		} catch (InputMismatchException ex) {continue;}
		}
		
		System.out.println("****************YOU WIN*****************");
		*/
	}
}
