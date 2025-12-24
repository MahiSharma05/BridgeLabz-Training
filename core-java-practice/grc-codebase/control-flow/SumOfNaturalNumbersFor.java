//Write a program to find the sum of n natural numbers using for loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 


import java.util.Scanner;

public class SumOfNaturalNumbersFor{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        // Check if input is a natural number
        if (n <= 0) {
            System.out.println("Please enter a valid natural number.");
        } 
		
		// Compute sum using for loop
		else {
            int sumFor = 0;
            for (int i = 1; i <= n; i++) {
                sumFor = sumFor + i;
            }

            // Compute sum using formula
            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using for loop :" + sumFor);
            System.out.println("Sum using formula :" + sumFormula);

            // Compare results
            if (sumFor == sumFormula) {
                System.out.println("Result: Both computations are correct.");
            } 
			else {
                System.out.println("Result: Computations do NOT match.");
            }
        }

        input.close();
    }
}
