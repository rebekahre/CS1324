import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		String[] arrayPerfect = readFilePerfect("common-dictionary.txt");
		
		final int SIZE = 100;
		String[] arrayOversize = new String[SIZE];
		int result = readFileOversize("personal-dictionary.txt", arrayOversize);
		
		System.out.println("Spell Checker");
		System.out.println("-------------");
	
		int count = 0;
		String word = keyboard.nextLine().toLowerCase();
		System.out.println("Enter a word or 'quit' to stop:" + word);
		
		while(!(word.equals("quit"))) {
			if(checkSpelling(word, arrayPerfect, arrayOversize, result)) {
				System.out.println("The word is spelled correctly.");
			}
			else {
				System.out.println("The word was not found in the dictionary.");
				System.out.println("Would you like to add it to your personal dicionary (yes/no)?");
				String answer = keyboard.nextLine().toLowerCase();
				if(answer.equals("yes")) {
				System.out.println("Enter a word or 'quit' to stop:" + word);
				arrayOversize[result] = word;
				++count;
				Arrays.sort(arrayOversize, 0, result);
				}
			}
			word = keyboard.nextLine().toLowerCase();
			}
		
		System.out.println();
		System.out.println("Enter a word or 'quit' to stop:" + word);
		keyboard.close();
		
		writeFile("personal-dictionary.txt", arrayOversize, result);
		System.out.println("goodbye!");
		}
	
	public static String[] readFilePerfect(String fileName) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		int count = 0;
		while(file.hasNextInt()) {
			file.nextInt();
			++count;
		}
		file.close();
		
		Scanner newFile = new Scanner(new File(fileName));
		String[] readFile = new String[count];
		for(int i=0; i<count; ++i) {
			String name = newFile.nextLine();
			readFile[i] = name;
		}
		return readFile;
	}
	
	
	public static int readFileOversize(String fileName, String[] array) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		file.createNewFile();
		
		Scanner secondList = new Scanner(file);
		
		int lines = 0;
		for(int i=0; i<array.length; ++i) {
			String name = secondList.nextLine();
			array[i] = name;
			++lines;
		}
		return lines;
	}
	
	
	public static boolean checkSpelling(String word, String[] dictionary, String[] personal, int size) {
		Arrays.sort(personal, 0, size);
		
		if(Arrays.binarySearch(dictionary, word) >= 0) {
			return true;
		}
		
		if(Arrays.binarySearch(personal, 0, size, word) >= 0) {
			return true;
			
		}
		return false;
		}

	
	public static void writeFile(String fileName, String[] array, int size) throws FileNotFoundException {
		File file = new File(fileName);
		PrintWriter writer = new PrintWriter(new File(fileName));
		
		for(int i=0; i<size; ++i) {
			writer.println(array[i]);
		}
		writer.close();
	}
}
	
	
	
	
	
	
	

