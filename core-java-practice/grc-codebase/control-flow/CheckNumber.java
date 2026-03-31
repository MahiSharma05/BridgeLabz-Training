//Write a program to check whether a number is positive, negative, or zero. 

import java.util.Scanner;

public class CheckNumber{
    public static void main(String [] args){
	
	  Scanner input = new Scanner(System.in);	
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		
		if(number > 0){
		    System.out.println("positive");
		}
		else if(number < 0){
		    System.out.println("Negative");
		}
		else{
		    System.out.println("Zero");
		}
	}
}
