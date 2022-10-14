import java.util.Scanner;
public class Project3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the yarn specified by your "
				+ "pattern.");
		String name1 = keyboard.nextLine();	
		System.out.println("Enter the number of balls of " + name1 + " "
				+ "that are required.");
		
		int numBalls = keyboard.nextInt();
		keyboard.nextLine();
		if (numBalls <= 0) {
			System.out.println("The number of balls must be positive. Please re-enter.");
			
			numBalls = keyboard.nextInt();
			keyboard.nextLine();			
		}
		System.out.println("Enter the number of yards per ball of " + name1 + "."); 
		int yardsBall = keyboard.nextInt();
		keyboard.nextLine();
		if (yardsBall <= 0) {
			System.out.println("The number of yards must be positive. Please re-enter.");
			
			yardsBall = keyboard.nextInt();
			keyboard.nextLine();
		}
		System.out.println("Enter the name of the substitue yarn.");
		String name2 = keyboard.nextLine();
		System.out.println("Enter the number of yard per ball of " + name2 + ".");
		int yardsBall2 = keyboard.nextInt();
		keyboard.nextLine();
		if (yardsBall2 <=0) {
			System.out.println("The number of yards must be positive. Please re-enter.");
			
			yardsBall2 = keyboard.nextInt();
			keyboard.nextLine();
		
		}
		int numYards = numBalls * yardsBall;
		double quantity = numYards / (double)yardsBall2;
		int numBalls2 = (int)Math.ceil(quantity);
		
		System.out.println("You should purchase " + numBalls2 + " balls of " + name2 + " instead of " + numBalls + " balls of " + name1 + ".");
		
		keyboard.close();
	}
	
}
