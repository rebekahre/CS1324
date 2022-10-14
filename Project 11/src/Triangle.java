import java.text.DecimalFormat;

public class Triangle {
	
	//implement instance data for all sides.
	private double sideA;
	private double sideB;
	private double sideC;
	//round any values with more than 3 digits after the decimal point to the thousandths place.
	private static final DecimalFormat FORMATER = new DecimalFormat("#.###");
	
	
	
	/**
	 * Implement the constructor. 
	 * Each triangle object has its own copies. If isTriangle returns true, assign the constructor 
	 * arguments to sideA, sideB, and sideC.
	 * Make each side to 1 if it's a negative number.
	 * @param sideA is sideA of a triangle.
	 * @param sideB is sideB of a triangle.
	 * @param sideC is sideC of a triangle.
	 */
	public Triangle(double sideA, double sideB, double sideC) {
		
		if(isTriangle(sideA, sideB, sideC)) {
		
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;		
		}
		else {
			
			this.sideA = 1;
			this.sideB = 1;
			this.sideC = 1;
		}
		
	}
	
	
	//implement the accessors. "getter" is a public accessor. It returns each side of a triangle.
	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}
	
	public double getSideC() {
		return sideC;
	}
	
	public String toString() {
	//Since the constant FORMATER is static, it can be used by all the Triangle objects.
		return("Triangle(" + FORMATER.format(sideA)+ ", " + FORMATER.format(sideB)+ 
				", " + FORMATER.format(sideC) + ")");
	}
	
	
	
	//implement the mutators for all sides. Each side must be positive. "setter" is a private accessor.
	//The setter just needs to check whether changing its corresponding variable will put the object 
	//in an invalid state. If so, the setter should leave the variable unchanged.
	public boolean setSideA(double sideA) {
		//returns a boolean value to indicate whether the Triangle was changed.
		if(isTriangle(sideB, sideC, sideA)) {
		this.sideA = sideA;
		return true;
		}
		else {
			return false;
		}
	}
	
	public boolean setSideB(double sideB)= {
		if(isTriangle(sideB, sideC, sideA)) {
		this.sideB = sideB;
		return true;
		}
		else {
			return false;
		}
	}
	
	public boolean setSideC(double sideC) {
		if(isTriangle(sideB, sideC, sideA)) {
		this.sideC = sideC;
		return true;
		}
		else {
			return false;
		}
	}
	
	
	
	//Write a helper method. It returns false if either constraint is violated.
	//The method should return true only if BOTH constraints are satisfied. 
	//This is a private static method because only the constructor and setters need to call it.
	private static boolean isTriangle(double a, double b, double c) {
		//the sum of two sides must be greater than the third to make a triangle.
		//and no sides should be negative.
		if((b+c > a && a+c > b && a+b > c) && (a > 0.0 && b >0.0 && c>0.0)) {
			return true;
		}
			else {
			return false;	
		}
	}
}
