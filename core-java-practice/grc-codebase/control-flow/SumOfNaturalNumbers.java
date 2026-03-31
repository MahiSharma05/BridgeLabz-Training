//Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 

import java.util.Scanner;

public class SumOfNaturalNumbers{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n <= 0){
            System.out.println("Please enter a valid natural number.");
        } 
		else 
		{
            int i = 1;
            int sumWhile = 0;
            while (i <= n) {
                sumWhile = sumWhile + i;
                i++;
            }

            // Compute sum using formula
            int sumFormula = n * (n + 1) / 2;
            System.out.println("Sum using while loop :" + sumWhile);
            System.out.println("Sum using formula :" + sumFormula);

            // Compare results
            if (sumWhile == sumFormula){
                System.out.println("Result: Both computations are correct.");
            }
			else{
                System.out.println("Result: Computations do NOT match.");
            }
        }
    }
}
