//Write a program FizzBuzz, take a number as user input, and check for a positive integer. If positive integer, loop and print the number, but for multiples of 3 print "Fizz" instead of the number, for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz", using for loop.

import java.util.Scanner;

public class FizzBuzzfor{
    public static void main(String[] args){
	
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");
        int number = input.nextInt();

        // Check for positive integer
        if(number <= 0){
            System.out.println("Please enter a valid positive integer.");
        }
		else{
            for(int i = 1; i <= number; i++){
                if(i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
				else if(i % 3 == 0){
                    System.out.println("Fizz");
                }
				else if(i % 5 == 0){
                    System.out.println("Buzz");
                } 
				else{
                    System.out.println(i);
                }
            }
        }

        input.close();
    }
}
