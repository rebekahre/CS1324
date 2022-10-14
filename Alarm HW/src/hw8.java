import java.util.Scanner;

public class hw8 {

	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		final int SENTINEL = -1;
		int input = keyboard.nextInt();
		
		for (int sum = 0; input != SENTINEL; ++sum) {
			sum = sum + input * input;
			input = keyboard.nextInt();
		}
		keyboard.close();
	}
}
		
		