import java.util.Scanner;

public class Project5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//constant sentinel value
		//for a grade average, data will be greater than or equal to zero
		final int SENTINEL = -1;
		
		int data = 3;
		//Setting up accumulators
		
		int prevData;
		int posChange = 0;
		int negChange = 0;
		int noChange = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		
		System.out.println("Response Dial Simulator");
		System.out.println("-----------------------");
		System.out.println("Initial setting: " + data);
		
		//Setting up a value to account for previous data entries
		prevData = data;
		
		System.out.println("Enter the next setting (1-5) or -1 to stop.");
		//Priming read
		data = input.nextInt();
		
		//Starting a loop that will finish when the user enters the sentinel value
		while(data != SENTINEL) {
			//Counting the number of times a user selects a specific value
			if (data == 1) {
				one = one + 1;
			}
			else if (data == 2) {
				two = two + 1;
			}
			else if (data == 3) {
				three = three + 1;
			}
			else if (data == 4) {
				four = four + 1;
			}
			else if (data == 5) {
				five = five + 1;
	}
			//Counting the number of times the user has a positive, negative, or no change.
			if ((data - prevData) < 0) {
				negChange = negChange + 1;
				System.out.println("Negative change: " + prevData + " to " + data);
			}
			else if ((data - prevData) > 0) {
				posChange = posChange + 1;
				System.out.println("Positive change: " + prevData + " to " + data);
			}
			else if ((data - prevData) == 0) {
				noChange = noChange + 1;
				System.out.println("No change: " + prevData + " to " + data);
			}
			System.out.println("Current Setting: " + data);
			prevData = data;
			System.out.println("Enter the next setting (1-5) or -1 to stop.");
			data = input.nextInt();
}
		System.out.println("Response Summary");
		System.out.println("----------------");
		
		System.out.println("1 was chosen " + one + " time(s).");
		System.out.println("2 was chosen " + two + " time(s).");
		System.out.println("3 was chosen " + three + " time(s).");
		System.out.println("4 was chosen " + four + " time(s).");
		System.out.println("5 was chosen " + five + " time(s).");
		
		System.out.println();
		System.out.println("Positive changes: " + posChange);
		System.out.println("Negative changes: " + negChange);
		System.out.println("No changes: " + noChange); 
		
		input.close(); 
	}
		}
		
