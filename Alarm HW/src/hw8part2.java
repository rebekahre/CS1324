import java.util.Scanner;

public class hw8part2 {
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);

	double sum = 0.0;
	final double EPSILON = .0001;
	double previous = 0;
	int count = 1;

	while (count <= 10 && sum - previous < EPSILON) {
		sum = sum + 1.0 / count;
		previous = sum;
		++count;
	}
	keyboard.close();
}
}