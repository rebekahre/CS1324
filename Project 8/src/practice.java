import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class practice {
	public static void main(String[] args) throws FileNotFoundException {
		String[] array = readFile("movie-data.txt");
		lowercase(array);
		
		String popularTitle = findMostFrequent(array);
		System.out.println("Most popular movie:" + popularTitle);
		
	}
	
	
	public static String[] readFile(String filename) throws FileNotFoundException {
		Scanner file = new Scanner(new File(filename));
		int countLines = 0;
		while(file.hasNextLine()) {
			file.hasNext();
			++countLines;
		}
		file.close();
		
		Scanner newFile = new Scanner(new File(filename));
		String[] reading = new String[countLines];
		for(int i=0; i<countLines; ++i) {
			String name = newFile.nextLine();
			reading[i] = name;
		}
		return reading;
	}
	
	
	public static void lowercase(String[] array) {
		for(int i=0; i<array.length; ++i) {
			String tempWord = array[i].toLowerCase();
			array[i] = tempWord;
		}
	}
	
	
	public static String findMostFrequent(String[] array) {
		Arrays.sort(array);
		int countSame = 0;
		int max = 0;
		String movieTitle = null;
		for(int i=1; i<array.length; ++i) {
			String movie1 = array[i];
			String movie2 = array[i-1];
			if(movie1.equals(movie2)) {
				++countSame;
			}
			else if(!(movie1.equals(movie2))) {
				countSame = 0;
			}
			else if (countSame > max) {
				max = countSame;
				movieTitle = array[i];
			}
			else {
				countSame = 1;
			}
		}
		return movieTitle;
	}
	
	
	
}
