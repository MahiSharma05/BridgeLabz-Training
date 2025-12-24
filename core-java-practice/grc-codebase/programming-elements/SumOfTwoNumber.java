//Write a program that takes two numbers as input from the user and prints
import java.util.Scanner;

public class SumOfTwoNumber{
    public static void main(String[] args){
	
	    Scanner input = new Scanner(System.in);
		
	    System.out.println("Enter first number");
		int number1 = input.nextInt();
		
	    System.out.println("Enter second number");
		int number2 = input.nextInt();
		
		int sum = number1 + number2;
		System.out.println("sum : "+ sum);
	}
}	