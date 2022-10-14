// James Dizikes
// CS 1323/1324, Fall 2019
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args)
		throws FileNotFoundException, IOException {

		final String FILENAME_COMMON = "common-dictionary.txt";
		final String FILENAME_PERSONAL = "personal-dictionary.txt";
		final int CAPACITY_PERSONAL_DICT = 100;
		String prompt = "Enter a word or 'quit' to stop: ";

		// Read the common dictionary and store the words in an array.
		ArrayList<String> common = readFile(FILENAME_COMMON);

		// Construct an oversize array to store the personal dictionary.
		ArrayList<String> personal = new ArrayList<String> (CAPACITY_PERSONAL_DICT);
		
		// Construct a Scanner to read user input from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Spell Checker");
		System.out.println("-------------");
		
		// Perform a priming read to get the first word.
		System.out.print(prompt);
		String word = keyboard.nextLine().toLowerCase();
		
		// Enter the user input loop.
		while (!word.equals("quit")) {
			
			// Check if the word is in either dictionary.
			if (checkSpelling(word, common, personal)) {
				System.out.println("The word is spelled correctly.");
			} 
			else {
				System.out.println("The word was not found in the "
					+ "dictionary.");			
				System.out.println("Would you like to add it to your personal "
					+ "dictionary (yes/no)?");
				String response = keyboard.nextLine().toLowerCase();
				
				// If the user responds "yes" and there is room in the oversize
				// array, add the word to the end of the array and sort it.
				if (response.equals("yes")) {
					personal.add(word);
				}
			}
			
			// Get the next word from the user.
			System.out.println();
			System.out.print(prompt);
			word = keyboard.nextLine().toLowerCase();
		}
		
		keyboard.close();
		writeFile(FILENAME_PERSONAL, personal);
		System.out.println("Goodbye!");
	}
	
	// Read each line of a file and store them in a perfect size array.
	public static ArrayList<String> readFile(String filename) 
		throws IOException {
		// Construct a file object for the file with the given name.
		File file = new File(filename);
		
		// If the file does not exist, create it.
		file.createNewFile();

		ArrayList<String> lines = new ArrayList<String>();
		
		// Construct a scanner to read the file.
		Scanner scan = new Scanner(file);

		// Store each line of the file in the array. Exit the loop when the 
		// array is full or the entire file has been read.
		while (scan.hasNextLine()) {
			lines.add(scan.nextLine());
		}

		scan.close();

		return lines;
	}

	// Return true if word is in either array; otherwise, return false. Note 
	// that the arrays are sorted, so binary search can be used.
	public static boolean checkSpelling(String word, ArrayList<String> common, 
		ArrayList<String> personal) {
		
		Collections.sort(personal);
		
		
		if (Collections.binarySearch(common, word) >= 0) {
			return true;
		}
		
		if (Collections.binarySearch(personal, word) >= 0) {
			return true;
		}
		
		return false;
	}
	
	// Write the nonempty elements of an oversize array to a given file.
	public static void writeFile(String filename, ArrayList<String> array)
			throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);

		for (int idx = 0; idx < array.size(); ++idx) {
			writer.println(array.get(idx));
		}

		// Close the file; otherwise, the contents will be lost.
		writer.close();
	}
}

