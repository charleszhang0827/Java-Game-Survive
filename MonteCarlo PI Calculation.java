import java.util.Random;
import java.util.Scanner;

public class MonteCarloPICalculation {
	//Global Variable
	public static MonteCarloPICalculation MCPCO;
	
	public int totalTries;
	
	public int outside;
	
	public int inside;
	
	public int count=0;
	
	public double canvasWidth=1000, canvasHeight=1000;
	
	public double myPI;
	
	public double bigCircleRadius=500;
	
	public Random random;
	
	public Scanner scan;
	
	//constructor
	public MonteCarloPICalculation() {
		//call the getTotalTries method
		getTotalTries();
		//initialize new object for Random
		random=new Random();
		
		for(int i=0;i<totalTries;i++) {
			//Since it's inside the constructor and inside the for loop
			//Local Variable
			double dotXPosition=random.nextFloat()*canvasWidth;
			double dotYPosition=random.nextFloat()*canvasHeight;
			//call the inOrOut method with two arguments dotXPosition and dotYPosition
			inOrOut(dotXPosition,dotYPosition);
		}
		//after the for loop we print out the for loop
		System.out.println("The value of my PI after "+count+" is "+myPI);
	}
	
	public void getTotalTries() {
		//while loop 
		while(true) {
			//initialize new object for Scanner
			scan=new Scanner(System.in);
			System.out.println("How many total tires?");
			try {
				//initialize totalTries with the user input
				totalTries=scan.nextInt();
				//jump out from the loop
				break;
				//if it's the wrong data type (non-integer)
				//then do the following code
			}catch(Exception e) {
				System.out.println("Please enter a integer eg.6");
			}
		}
	}
	
	public void inOrOut(double x,double y) {
		//get the value for the adjacent side by getting the absolute value of the subtraction 
		//between the center of the circle 500 and the position of the x position of the dot
		double adjacent=Math.abs(x-500);
		//get the value for the opposite side by getting the absolute value of the subtraction 
		//between the center of the circle 500 and the position of the y position of the dot
		double opposite=Math.abs(y-500);
		//use the the Pythagorean Theorem to get the hypotenuse side a2+b2=c2
		//The square root of the sum of adjacent*adjacent+opposite*opposite
		double hypotenuse=(double) Math.sqrt(Math.pow(adjacent, 2)+Math.pow(opposite, 2));
		
		if(hypotenuse>500) {
			//if the hypotenuse is bigger than the radius of the big circle then it's outside of the circle
			outside++;
			count++;
		}else if(hypotenuse<500) {
			//if the hypotenuse is smaller than the raius of the small circle then it's inside of the circle
			inside++;
			count++;
		}else if(hypotenuse==500) {
			//this is an exception that is neither inside or outside
			//so we subtract one try from the totalTires
			totalTries--;
		}
		//we call the calculatePI method with two arguments of inside and totalTries
		calculatePI(inside,totalTries);
	}
	
	public void calculatePI(double inside,double totalTries) {
		double ratio=inside/totalTries;
		
		double canvasArea=canvasWidth*canvasHeight;
		
		double CircleArea=canvasArea*ratio;
		
		//the formula for calculate the area of a circle is pi*radius*radius
		//so pi=circleArea/radius/radius
		myPI=CircleArea/bigCircleRadius/bigCircleRadius;
	}
	
	public static void main(String[]args) {
		MCPCO=new MonteCarloPICalculation();
	}
}
sdadas
