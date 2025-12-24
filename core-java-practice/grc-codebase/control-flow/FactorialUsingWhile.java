//Write a Program to find the factorial of an integer entered by the user.

import java.util.Scanner;

public class FactorialUsingWhile{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = input.nextInt();

        // Check if input is positive
        if (num < 0) {
            System.out.println("Please enter a positive integer.");
        }
		else {
            int factorial = 1;
            int i = 1;
            // Compute factorial using while loop
            while (i <= num) {
                factorial = factorial * i;
                i++;
            }
            // Display result
            System.out.println("Factorial of "+ num + "is: "+ factorial);
        }

        input.close();
    }
}
