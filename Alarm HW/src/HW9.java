import java.util.Arrays;
import java.util.Scanner;

public class HW9 {
	public static void main(String[] args) {
	int[] data = {2, 5, 10, 11, -1};
	int[] copy = Arrays.copyOf(data, data.length);
	
	Arrays.sort(copy); 
	
	if (Arrays.binarySearch(copy, -1) >= 0) 
	{
		System.out.println("found");
		}
		else
		{
		System.out.println("not found");
		}
		}
	}



