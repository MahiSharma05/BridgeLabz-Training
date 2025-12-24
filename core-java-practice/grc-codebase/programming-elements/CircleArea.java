//Write a program to calculate the area of a circle. Take the radius as input

import java.util.Scanner;

public class CircleArea{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the radius: ");
		double radius = input.nextDouble();
		final double PI = 3.14;
		
		double area = PI * radius * radius;
		System.out.println("area of a circle: " + area);
	  
	    input.close();
	}
}