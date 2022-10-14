import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		final int SENTINEL = -1;
		int dial = 3;
		
		System.out.println("Response Dial Simulator");
		System.out.println("-----------------------");
		System.out.println("Initial setting: " + dial);
		System.out.println("Enter the next setting (1-5) or -1 to stop.");
		int answer = keyboard.nextInt();
		int positiveCount1 = 0;
		int positiveCount2 = 0;
		int negativeCount1 = 0;
		int negativeCount2 = 0;
		int negativeCount3 = 0;
		int count = 0;
		while (answer != SENTINEL) {
			if(answer == 5) {
			
			System.out.println("Positive change: " + dial + "to " + answer);
			System.out.println("Current setting: " + answer);
			++positiveCount1;
			
		}
			else if (answer == 4) {
				dial = dial + 1;
				System.out.println("Positive change: " + dial + "to " + answer);
				System.out.println("Current setting: " + answer);
				++positiveCount2;
			}
			else if (answer == 3) {
				dial = dial;
				System.out.println("Positive change: " + dial + "to " + answer);
				System.out.println("Current setting: " + answer);
				++count;
			}
			else if (answer == 2) {
				dial = dial - 1;
				System.out.println("Positive change: " + dial + "to " + answer);
				System.out.println("Current setting: " + answer);
				++negativeCount1;
			}
			else if (answer == 1) {
				dial = dial - 2;
				System.out.println("Positive change: " + dial + "to " + answer);
				System.out.println("Current setting: " + answer);
				++negativeCount2;
			}
			else if (answer == 0) {
				dial = dial - 3;
				System.out.println("Positive change: " + dial + "to " + answer);
				System.out.println("Current setting: " + answer);
				++negativeCount3;
			}
			else {
			}
		}
	
		System.out.println("Response Summary");
		System.out.println("----------------");
		System.out.println("1 was chosen " + negativeCount2 + "time(s).");
		System.out.println("2 was chosen " + negativeCount1 + "time(s).");
		System.out.println("3 was chosen " + count + "time(s).");
		System.out.println("4 was chosen " + positiveCount2 + "time(s).");
		System.out.println("5 was chosen " + positiveCount1 + "time(s).");
		
		System.out.println("Positive changes: " + positiveCount1 + positiveCount2);
		System.out.println("Negative changes: " + negativeCount1 + negativeCount2);
		System.out.println("No changes: " + count);
		
		keyboard.close();
	}
}

