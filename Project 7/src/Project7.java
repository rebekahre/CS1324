/**
 * @author Deborah A. Trytten
 * @version 1.0
 * Updated to v1.1 by James Dizikes on Oct 7, 2019.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Project7 {
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		final int INITIAL_TOKENS = 10;
		final int PLAY_COST = 1;
		String prompt = "Press enter to play (spend " + PLAY_COST + " token) "
					  + "or type 'quit' to stop.";
		
		// Initialize the game.
		int tokens = INITIAL_TOKENS;
		boolean playGame = true;
		
		// Introduce the game to the player.
		System.out.println("Java Slot Machine");
		System.out.println("-----------------");
		
		// Perform a priming read.
		System.out.println("Tokens: " + tokens);
		System.out.println(prompt);
		if (keyboard.nextLine().equalsIgnoreCase("quit")) {
			playGame = false;
		}
		
		// Enter the game loop.
		while (playGame)
		{
			// Decrease the player's tokens by the cost to play the game.
			tokens = tokens - PLAY_COST;
			
			// Add your code in the following section. You do not need to 
			// change any other part of the main method.
			//-----------------------------------------------------------------
			
			// Spin the wheels. (That is, generate an array of random numbers.)
			int [] wheelNums = randomIntArray(2, 7, 3);
			// Print the numbers on the wheels to the player.
			System.out.println("Spin: [" + wheelNums[0] +", " + wheelNums[1] + ", " + wheelNums[2] + "]");
			
			// Calculate the number of tokens won.
			int tokensWon = calculateWinnings(wheelNums);
			
			//-----------------------------------------------------------------
			
			// Update the player's tokens.
			tokens = tokens + tokensWon;
			
			// Prompt the player if they still have tokens.
			if (tokens > 0) {
				System.out.println("Tokens: " + tokens);
				System.out.println(prompt);
				if (keyboard.nextLine().equalsIgnoreCase("quit")) {
					playGame = false;
				}
			}
			else {
				playGame = false;
			}
		}
		
		// Print final tokens and amount won/lost.
		System.out.println("You quit with " + tokens + " token(s).");
		System.out.println("Your net profit is " + (tokens - INITIAL_TOKENS) 
						 + " token(s).");
		
		keyboard.close();
	}
	
	/** Return a random integer between lowerBound and upperBound (inclusive).
	 * @param lowerBound  the lower bound for the random integer
	 * @param upperBound  the upper bound for the random integer
	 * @return  a random integer uniformly distributed between lowerBound and 
	 * upperBound
	 */
	public static int randomInt(int lowerBound, int upperBound)
	{
		int randomNumber = lowerBound + (int)(Math.random() * (upperBound - lowerBound + 1));
		return randomNumber;  
	}
	
	/** Return an array that contains size random integers, each between 
	 * lowerBound and upperBound (inclusive).
	 * @param lowerBound  the smallest random integer that can be generated
	 * @param upperBound  the largest random integer that can be generated
	 * @param size  the number of integers in the returned array
	 * @return  a newly constructed array containing size random integers
	 */
	public static int[] randomIntArray(int lowerBound, int upperBound, int size)
	{	
		int[] array = new int [size];
		int i;
		
		for (i = 0; i < size; ++i) {
			array[i] = randomInt(lowerBound, upperBound);
		}
		//Use for loop and call the random int method and store the returned int in each element of array. 
		return array;  
	}

	/** Return the number of tokens that the player won, and print a message to 
	 * the player. (See the project instructions for details.)
	 * @param wheelNums  an array of three integers that are the numbers shown 
	 * on the slot machine wheels
	 * @return  the number of tokens won
	 */
	public static int calculateWinnings(int[] wheelNums)
	{
		//sort the array
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