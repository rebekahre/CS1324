import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Project8
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String[] movieList = readFile("movie-data.txt");
		lowercase(movieList);
		
		String popularTitle = findMostFrequent(movieList);
		System.out.println("Most popular movie: " + popularTitle);
	}

	public static String[] readFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(filename));
		
		//Create a while loop to count the number of lines the file has. 
		int count = 0;
		while(file.hasNextLine()) {
			++count; 
			file.nextLine();
		}
		file.close();
		
		String[] movieNames = new String[count];
		
		Scanner newFile = new Scanner(new File(filename));
		
		//This for loop creates an array of the movie names.
		for(int i = 0; i < count; ++i) {
			String name = newFile.nextLine();
			movieNames[i] = name;
		}
		return movieNames;
	}

	public static void lowercase(String[] array)
	{
		//This for loop takes each element of the array and reassigns it to be lowercase.
		for(int i = 0; i < array.length; ++i) {
			String tempWord = array[i];
			tempWord = tempWord.toLowerCase();
			array[i] = tempWord;
		}

	}

	public static String findMostFrequent(String[] array)
	{
		//This sorts the array into alphabetical order so we can compare the different elements.
		Arrays.sort(array);
		
		int max = 0;
		int count = 0;
		String popularTitle = null;
		
		//This for loop will compare each element in the array to the one before it, and if they are the same, it will increment the count.
		for(int i = 1; i < array.length; ++i) {
			String movie1 = array[i];
			String movie2 = array[i-1];
			
			if (movie1.compareTo(movie2) == 0) {
				++count;
				
				if (count > max) {
					popularTitle = array[i];
					max = count;
				}
			}
			else {
				//We start count at 1 and not 0 because if the two movies do not equal to each other, then the count restarts to one with the new
				//movie title. 
				count = 1;
			}
		}
		
		return popularTitle;
	}
}