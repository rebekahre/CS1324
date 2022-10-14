import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int sum = 0;
		
		System.out.println("Answer yes or no to the following questions");
		System.out.println("I am losing my sense of humor.");
		String answer = keyboard.nextLine();
		if(answer.equalsIgnoreCase("yes")) {
			sum = sum + 1;
		}
			
		
		System.out.println("I find it more and more difficult to see people socially.");
		answer = keyboard.nextLine();
		if(answer.equalsIgnoreCase("yes")) {
			sum = sum + 1;
			
		}
		
		System.out.println("I feel tired most of the time.");
		answer = keyboard.nextLine();
		if(answer.equalsIgnoreCase("yes")) {
			sum = sum + 1;
		}
		
		if(sum == 0) {
		System.out.println("You're more exhausted than stressed out");
	}
		else if (sum == 1) {
			
		System.out.println("You're beginning to stress out");
	}
		else if (sum == 2) { 
		System.out.println("You're possibly stressed out");
		}
		else {
		System.out.println("You're probably stressed out");
		}
		keyboard.close();
}
}

	

