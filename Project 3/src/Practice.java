import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the name of the yarm specified by your pattern.");
		String name = input.nextLine();
		
		System.out.println("Enter the number of balls of " + name + " that are required.");
		int numBalls = input.nextInt();
		if(numBalls <= 0) {
			System.out.println("The number of balls must be positive. Please re-enter.");
			int newNumBalls = input.nextInt();
			input.nextLine();
		}
		
		System.out.println("Enter the number of yards per ball of " + name + ".");
		int numYards = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter the name of the substitute yarn.");
		String subYarn = input.nextLine();
		
		
		System.out.println("Enter the number of yards per ball of " + subYarn + ".");
		int numYards2 = input.nextInt();
		
		if(numYards2 <= 0) {
			System.out.println("The number of yards must be positive. Please re-enter.");
			int newSubYarn = input.nextInt();
			input.nextLine();
		}
		
		int newNumYards = numBalls * numYards;
		double quantity = (double)newNumYards/numYards2;
		
		int wholeSubYarn = (int)Math.ceil(quantity);
		
		System.out.println("You should purchase " + wholeSubYarn + "balls of " + subYarn + " instead of "
				+ newNumYards + " balls of " + name + ".");
		
		input.close();
	}
}
