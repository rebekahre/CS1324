import java.util.ArrayList;

//This class will exercise all of the methods in the program and make sure they are working as described.
public class Driver {
	public static void main(String[] args) {
	
	//Creatting an ArrayList will allow you to manipulate the Triangle objects using a for loop.
	ArrayList<Triangle> list = new ArrayList <Triangle>();
	
	//Put five triangle objects in the ArrayList with each side lengths.
	list.add(new Triangle(1, 2, 3));
	list.add(new Triangle(2, 3, 4));
	list.add(new Triangle(3, 4, 5));
	list.add(new Triangle(4, 5, 6));
	list.add(new Triangle(5, 6, 7));

	System.out.println("New objects");
	System.out.println(list + "\n");
	
	//use accessor methods to print out the side lengths of your triangles. 
	//Some of these changes will not be legal.
	System.out.println("Using Accessors");
	//use foreach loop
	for(Triangle triangle: list) {
		System.out.println("Triangle: " + triangle.getSideA() + " " + triangle.getSideB() + 
				" " + triangle.getSideC());
	}
	
	
	//use the mutator to set the side length of side A to 10.
	//Some of these changes will not be legal.
	System.out.println();
	for(Triangle triangle: list) {
		triangle.setSideA(10);
	}
	System.out.println("After Side A changed" );
	System.out.println(list);
	System.out.println();
	
	
	//use the mutator to change the side length of side B for all triangles to 10.
	//Some of these changes will not be legal.
	for(Triangle triangle: list) {
		triangle.setSideB(10);
	}
	System.out.println("After Side B changed" );
	System.out.println(list);
	System.out.println();
	
	
	//use the mutator to change the side length of side C for all triangles to 10.
	//Some of these changes will not be legal.
	for(Triangle triangle: list) {
		triangle.setSideC(10);
	}
	System.out.println("After Side C changed" );
	System.out.println(list);
	
	}
}
