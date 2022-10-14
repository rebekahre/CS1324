import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
	
		final int INITIAL_TOKENS = 10;
		final int PLAY_COST = 1;
		
		System.out.println("Java Slot Machine");
		System.out.println("-----------------");
		System.out.println("Tokens: " + INITIAL_TOKENS);
		System.out.println("Press enter to play (spend 1 token) or type 'quit' to stop.");
		
		System.out.println("Spin: [" + randomInt(lowerBound, upperBound))
	
		
	}
	
	public static int randomInt(int lowerBound, int upperBound) {
		int randomNum = lowerBound + (int)Math.random()*(upperBound - lowerBound+1);
		
		return randomNum;
	}
	
	
	public static int[] randomIntArray(int lowerBound, int upperBound, int size) {
		
		int[] newArray = new int [size];
		for(int i=0; i<newArray.length; ++i) {
			newArray[i] = randomInt(lowerBound, upperBound);
		}
		return newArray;
	}
	
	
	public static int calculateWinnings(int[] wheelNums) {
		Arrays.sort(wheelNums);
		
		int tokens = 0;
			if ((wheelNums[0] == wheelNums[1]) && (wheelNums[0] == wheelNums[2])) {
			if (wheelNums[0] == 7) {
				tokens = 50; 
				System.out.println("Triple 7s! You win 50 tokens."); }
				
				else {
					tokens = wheelNums[0] * 3;
					System.out.println("Triple " + wheelNums[0] + "s! You win " + tokens + " tokens.");
				}
			}
				else if ((wheelNums[0] == wheelNums[1]) || (wheelNums[0] == wheelNums[2]) || (wheelNums[1] == wheelNums[2])) {
					tokens = 1;
					System.out.println("Pair! You win 1 token.");
				}
				else if ((wheelNums[1] - wheelNums[0] == 1) && (wheelNums[2] - wheelNums[1] == 1)) {
					System.out.println("Sequence! You win 2 tokens.");
					tokens = 2;
				}
				else {
					System.out.println("Sorry, you lost :(");
			}
			return tokens;
		
	}
}
