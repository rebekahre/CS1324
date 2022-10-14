import java.util.*;

public class practice1 {
	public static void main(String[] args) {

	Scanner keyboard = new Scanner(System.in) ;
	
	int numGrades = 0;
	int grade = keyboard.nextInt();
	int[] array = new int [1000];

	while (grade != -1)
	{
		array[numGrades] = grade;
	  ++numGrades;
	  grade = keyboard.nextInt();
	   }
	System.out.println("return " + numGrades);
}

}
