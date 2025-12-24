//Write a program to count down the number from the user input value to 1 using a for loop for a rocket launch

import java.util.Scanner;

public class RocketLaunchCountDown{
    public static void main(String [] args){
	    Scanner input = new Scanner(System.in);
		
		System.out.println("Enter CountDown Number");
		int counter = input.nextInt();
		
		for(int i = counter; i >= 1; i--){
			System.out.println(i);
		}
	}
}