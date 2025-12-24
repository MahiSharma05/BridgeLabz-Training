//Write a program to check if the first is the smallest of the 3 numbers.

import java.util.Scanner;

public class CheckSmallestNumber{
    public static void main(String [] args){
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter first number");
		int number1 = input.nextInt();
		System.out.println("Enter second number");
		int number2 = input.nextInt();
		System.out.println("Enter third number");
		int number3 = input.nextInt();
		boolean isSmalest = (number1 < number2) && (number1 < number3);
		    System.out.println("the first number the smallest? " + isSmalest);
	}
}
		   