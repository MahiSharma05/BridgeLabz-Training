//Write a Program to find the factorial of an integer entered by the user using for loop.


import java.util.Scanner;

public class FactorialUsingFor{
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int num = input.nextInt();

        // Check for natural number
        if (num < 0) {
            System.out.println("Please enter a valid natural number.");
        } 
		else{
            int factorial = 1;
            // Compute factorial using for loop
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
            // Print result
            System.out.println("Factorial of "+ num + "is: "+ factorial);
        }
        input.close();
    }
}


