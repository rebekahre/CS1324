import java.util.Scanner;

public class Project2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double copy1 = 18.99;
		double copy2 = 11.99;
		double copy3 = 80.50;
		int numCopies1 = 2;
		int numCopies2 = 4;
		int numCopies3 = 1;
		final double SALES_TAX = 8.75;
		
		double preTax = (copy1 * numCopies1) + (copy2 * numCopies2) + (copy3 * numCopies3);
		double salesTax = preTax * SALES_TAX / 100;
		double totalCost = preTax + salesTax;
		
		System.out.println("Purchase " + numCopies1 + " copies of Three Sisters, Bi Feiyu. Each copy costs $" + copy1 + ".");
		System.out.println("Purchase " + numCopies2 + " copies of Song of Solomon, Toni Morrison. Each copy costs $" + copy2 + ".");
		System.out.println("Purchase " + numCopies3 + " copy of Owls Don't Have to Mean Death, Chip Livingston. Each copy costs $"
				+ copy3 + ".");
		System.out.println("Total before tax: $" + String.format("%.2f",preTax));
		System.out.println("Sales tax: $" + String.format("%.2f", salesTax));
		System.out.println("The total cost of your order will be $" + String.format("%.2f",totalCost));
		
			
		}
		
		
	}


