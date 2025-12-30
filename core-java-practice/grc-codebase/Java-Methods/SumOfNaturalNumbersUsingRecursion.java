// Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct. 

import java.util.Scanner;

public class SumOfNaturalNumbersUsingRecursion {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take  input
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        // Check for natural number
        if (n <= 0) {
            System.out.println("The number is not a Natural Number.");
        } else {

            // Sum using recursion
            int recursiveSum = sumUsingRecursion(n);

            // Sum using formula
            int formulaSum = sumUsingFormula(n);

            //  results
            System.out.println("Sum using Recursion: " + recursiveSum);
            System.out.println("Sum using Formula: " + formulaSum);

            // Compare results
            if (recursiveSum == formulaSum) {
                System.out.println("Both results are correct and equal.");
            } else {
                System.out.println("Results are not equal.");
            }
        }

        input.close();
    }

    // Recursive method to find sum of n numbers
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUsingRecursion(n - 1);
    }

    // Method to find sum using formula
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }
}
