import java.util.Scanner;

public class Project4 {
public static void main(String [] args) {
	Scanner input = new Scanner(System.in);
	// Declaring Variables
	int sum = 0;
	// Lets user know what to do
	System.out.println("Answer yes or no to the following questions");
	// first question for user to answer
	System.out.println("I find myself less eager to go back to work or to resume my chores after a weekend");
	String data = input.nextLine();
	// If statement: to compute and add up the data
	if(data.equalsIgnoreCase("yes")) {
		sum = sum + 1;
	}
	// second question
	System.out.println("I try to get away from people as soon as I can");
	data = input.nextLine();
	if(data.equalsIgnoreCase("yes")) {
		sum = sum + 1;
	}
	// third question
	System.out.println("I feel tired most of the time");
	data = input.nextLine();
	if(data.equalsIgnoreCase("yes")) {
		sum = sum + 1;
	}
	// The if/else statement computes the users input
	if(sum == 0) {
		// Answered no to all questions
		System.out.println("You're more exhausted than stressed out");
	}
	else if(sum == 1) {
		// answered yes to one question
		System.out.println("You're beginning to stress out");
	}
	else if(sum == 2) {
		// answred yes to two questions
		System.out.println("You're possibly stressed out");
	}
	else {
		// answered yes to all 3 questions
		System.out.println("You're probably stressed out");
	}
	input.close();
}
}