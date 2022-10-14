import java.util.Scanner;

public class MoreOrLess {

	public static void main(String[] args) 
	{
		// Do not edit the main program
		Scanner keyboard = new Scanner(System.in);
		
		int number = keyboard.nextInt();
		
		System.out.print(moreOrLess42(number));
		keyboard.close();
		
	}

	public static boolean moreOrLess42(int x) 
	{
		int rem = x % 42;
		
		if (rem==0) {
			return true;
		}
		if (rem==1) {
			return true;
		}
		if (rem==41) {
			return true;
		}
		else {
		return false;
		}
	}
}