//Write a program to check if the first, second, or third number is the largest of the three.

import java.util.Scanner;

public class CheckLargestNumber{
    public static void main(String [] args){
	    Scanner input = new Scanner(System.in);
		
		System.out.println("Enter First Number");
		int number1 = input.nextInt();
		
		System.out.println("Enter Second Number");
		int number2 = input.nextInt();
		
		System.out.println("Enter third Number");
		int number3 = input.nextInt();
		
		boolean largestFirst = (number1 > number2) && (number1 > number3);
		System.out.println("Is the first number the largest? " + largestFirst);
		
		boolean largestSecond = (number2 > number1) && (number2 > number3);
		System.out.println("Is the second number the largest? " + largestSecond);

		boolean largestThird = (number3 > number2) && (number3 > number1);
		System.out.println("Is the third number the largest? " + largestThird);			
	}
}
		
