import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Project9 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("Spell Checker");
		System.out.println("-------------");

		Scanner keyboard = new Scanner(System.in);
		//call the first method
		String[] vocabularies = readFilePerfect("common-dictionary.txt");
		
		//call the second method
		final int OVERSIZE = 100;
		String[] result = new String[OVERSIZE];
		int resultSize;
		resultSize = readFileOversize("personal-dictionary.txt", result);
		
		
		//use while loop to prompt and read words from the user until they enter "quit."
		boolean playing = true;
		int index = 0;
		//playing loop structure	
		while (playing) {
			System.out.print("Enter a word or 'quit' to stop: ");
			String currentWord = keyboard.nextLine().toLowerCase();
			if (currentWord.equalsIgnoreCase("quit")) {
				playing = false;
				keyboard.close();
				writeFile("personal-dictionary.txt", result, resultSize);
				System.exit(0);
			}
			
			if (checkSpelling(currentWord, vocabularies, result, resultSize)) {
				System.out.println("The word is spelled correctly.");
				System.out.println();
			}
			else {
				if (resultSize < result.length) {
					System.out.println("The word was not found in the dictionary.");
					System.out.println("Would you like to add it to your personal dictionary (yes/no)?");
					if (keyboard.nextLine().equals("yes")) {
						result[resultSize] = currentWord;
						resultSize++;
					}
					System.out.println();
				}
				
			}
			
		}
		//call the method writeFile to save the personal dictionary to the file "personal-dictionary.txt"
		writeFile("personal-dictionary.txt", result, resultSize);
	}
		

	
	//This method reads a text file with a given name and returns a perfect size array that contains each line of the file.
	public static String[] readFilePerfect(String fileName) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		
		//Create a while loop to count the number of lines the file has. 
		int numLines = 0;
		while (file.hasNextLine()) {
			++numLines;
			file.nextLine();		
		}
		file.close();
		
		String[] dictionaryList = new String[numLines];
		Scanner newFile = new Scanner(new File(fileName));
		
		//This for loop creates an array of the dictionary words.
		for(int i = 0; i < numLines; ++i) {
		String name = newFile.nextLine();
		dictionaryList[i] = name;
		}
		return dictionaryList;
	}
	
	
	
	//This method reads a text file with a given name, adds each line to an element of an oversize array,
	// and returns the number of lines. The method creates an empty file with the given name if one doesn't exist. 
	public static int readFileOversize(String fileName, String[] array) throws FileNotFoundException, IOException {
		//create empty text file.
		File file = new File(fileName);
		file.createNewFile();
		
		Scanner secondList = new Scanner(file);
		
		//use a while loop to add each line to the next empty element of the array.
		int numLines = 0;
		while(secondList.hasNextLine()) {
			array[numLines] = secondList.nextLine();
			++numLines;
		}
		secondList.close();
		return numLines; 
		}
	


	//Given a perfect size array of words, an oversize array of words, and a word,
	//this method returns true if the word is in either array. Otherwise, it returns false
	public static boolean checkSpelling(String word, String[] dictionary, String[] personal, int size) {
	
		//Always sort before using binary search.
		Arrays.sort(personal,0,size);
		
		//use binarySearch for perfect size array.
		if(Arrays.binarySearch(dictionary,word)>= 0) {
			return true;
		}
		
		//use binarySearch for oversize array.
		if(Arrays.binarySearch(personal,0,size,word)>=0) {
			return true;
		}
		return false;
	}

	
	
	//Given the name of a text file and an oversize String array, 
	//this method writes the (nonempty) array elements to successive lines of the file. 
	public static void writeFile(String fileName, String[] array, int size) throws FileNotFoundException{
		
		//Use a PrintWriter object to write each element to the file
		//making a new file, fileName here is what the file is called
		File file = new File(fileName);
		
		PrintWriter writer = new PrintWriter(file); 
		
		//write the array elements to the file (using a loop)
		for(int i=0; i<size; ++i) {
			writer.println(array[i]);
		}
		writer.close();
		System.out.println("Goodbye!");
	}
	
	}
