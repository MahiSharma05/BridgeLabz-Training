//Write a program that takes the temperature in Celsius as input and converts

import java.util.Scanner;

public class CelsiusToFahrenheitConverter{
    public static void main(String[] args){
	    
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the temperature in Celsius: ");
		int Celsius = input.nextInt();
		
		int Fahrenheit = (Celsius * 9/5) + 32;
		System.out.println("temperature in Fahrenheit: " + Fahrenheit);
	  
	}
}	