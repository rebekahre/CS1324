import java.util.Scanner;

public class Concatenate {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter integer values, “+ “ending with 0");
		String result = orderNumbers(keyboard);
		
		System.out.println(result);
		
		keyboard.close();
	}

public static String orderNumbers(Scanner keyboard) { 
		int value = keyboard.nextInt();
		String result = "";
		
		while (value != 0) {
			result = result + value;
			value = keyboard.nextInt();
			} // Line 17
		
		return result;
		}
	}
