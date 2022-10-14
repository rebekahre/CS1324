import java.util.Scanner;

public class MethodHW {
	
	public static void main(String[] args) {

	   Scanner keyboard = new Scanner(System.in);
	   
	   System.out.println("Enter the sum of all the values, enter -1 to stop");
	   int sum = 0;
	   final int SENTINEL = -1; 
	   sum = sumUntilSentinel(keyboard, SENTINEL);
	   System.out.println("The total values are: " + sum);
	  
	   keyboard.close();
}

	   
public static int sumUntilSentinel(Scanner keyboard, int sentinel) {
	int sum = 0;   
	int value = keyboard.nextInt();

	   while (value != sentinel)
	   {
		   sum = sum + value;
		   value = keyboard.nextInt();

	   }
	   return sum;
	}
}

