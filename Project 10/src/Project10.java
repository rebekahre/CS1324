import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Project10 {

	public static void main(String[] args)
		throws FileNotFoundException, IOException {
		final String FILENAME_COMMON = "common-dictionary.txt";
		final String FILENAME_PERSONAL = "personal-dictionary.txt";
		String prompt = "Enter a word or 'quit' to stop: ";

		// Read the common and personal dictionary and store the words in an ArrayList<String>.
		ArrayList<String> common = readFile(FILENAME_COMMON);
		ArrayList<String> personal = readFile(FILENAME_PERSONAL);
		
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
				System.out.println("The word was not found in the " + "dictionary.");			
				System.out.println("Would you like to add it to your personal " + "dictionary (yes/no)?");
				String response = keyboard.nextLine().toLowerCase();
				// If the user responds "yes" add it to the array list
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
	
	
	
	// Read each line of a file and store them in an ArrayList.
	public static ArrayList<String> readFile(String filename) 
		throws IOException {
		
		// Construct a file object for the file with the given name.
		File file = new File(filename);
				
		// If the file does not exist, create it.
		file.createNewFile();
			
		ArrayList<String> stringList = new ArrayList<String> ();
		
		// reads the filename and stores contents into string list. 
		Scanner scan= new Scanner(new File(filename));
		while (scan.hasNextLine()) {
			stringList.add(scan.nextLine()); 
		}
		scan.close();

		// Return the array that we made.
		return stringList;
	}

	
	
	// Return true if word is in either array; otherwise, return false. 
	public static boolean checkSpelling(String word, ArrayList<String> common, 
		ArrayList<String> personal) {
		//if common contains word or personal contains word, return true.
		Collections.sort(personal);
		Collections.sort(common);
		if (Collections.binarySearch(common, word) >= 0) {`
			return true;
		}
		if (Collections.binarySearch(personal,word) >= 0) {
			return true;
		}
		return false;
		
	}
	
	
	
	
	// Write the nonempty elements of an ArrayList to a given file.
	public static void writeFile(String filename, ArrayList<String> array)
			throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);

		//use array.size instead of length because we want to compare it from the amount of size we have.
		for (int idx = 0; idx < array.size(); ++idx) {
			//get the index 
			writer.println(array.get(idx));
		}

		// Close the file; otherwise, the contents will be lost.
		writer.close();
	}
}