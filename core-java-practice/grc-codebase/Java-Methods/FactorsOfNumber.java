// Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors. Also find the sum, sum of square of factors and product of the factors and display the results

import java.util.Scanner;

public class FactorsOfNumber {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Find factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.println("\nFactors of " + number + ":");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        // Calculations
        int sum = findSumOfFactors(factors);
        long product = findProductOfFactors(factors);
        double sumOfSquares = findSumOfSquares(factors);

        //  results
        System.out.println("\n\nSum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        input.close();
    }

    // Method to find factors and store them in an array
    public static int[] findFactors(int number) {

        int count = 0;

        // First loop: count factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize array with count
        int[] factors = new int[count];
        int index = 0;

        // Second loop: store factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Method to find sum of factors
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Method to find product of factors
    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Method to find sum of squares of factors
    public static double findSumOfSquares(int[] factors) {
        double sum = 0;
        for (int f : factors) {
            sum += Math.pow(f, 2);
        }
        return sum;
    }
}
