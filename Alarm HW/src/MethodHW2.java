import java.util.Scanner;

public class MethodHW2 {
	
	public static void main(String[] args) {

	   Scanner input = new Scanner(System.in);
	   
	   System.out.println("Enter the sum of all the values, enter 0 to stop");
	   int sum = 0;
	   final int ZERO = 0; 
	   sum = sumUntilZero(input, ZERO);
	   System.out.println("The total values are: " + sum);
	  
	   input.close();
}

	   
public static int sumUntilZero(Scanner input, int zero) {
	int sum = 0;   
	int value = input.nextInt();

	   while (value != zero)
	   {
		   sum = sum + value;
		   value = input.nextInt();

	   }
	   return sum;
	}
}