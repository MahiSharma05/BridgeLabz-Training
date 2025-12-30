// Write a program to find the factors of a number and perform various tasks using the factors array

import java.util.Arrays;

class NumberFactors {

    // Method to find factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count = 0;
        // First loop to count the number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        // Second loop to store the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to find the greatest factor using the factors array
    public static int greatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;
        for (int f : factors) {
            if (f > max) max = f;
        }
        return max;
    }

    // Method to find the sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    // Method to find the product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    // Method to find the product of cubes of factors
    public static long productOfCubes(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }
}

// Test class
public class NumberFactorsTest {
    public static void main(String[] args) {
        int number = 6; // Example number
        System.out.println("Number: " + number);

        // Find factors
        int[] factors = NumberFactors.findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));

        // Greatest factor
        int greatest = NumberFactors.greatestFactor(factors);
        System.out.println("Greatest factor: " + greatest);

        // Sum of factors
        int sum = NumberFactors.sumOfFactors(factors);
        System.out.println("Sum of factors: " + sum);

        // Product of factors
        long product = NumberFactors.productOfFactors(factors);
        System.out.println("Product of factors: " + product);

        // Product of cubes of factors
        long productCubes = NumberFactors.productOfCubes(factors);
        System.out.println("Product of cubes of factors: " + productCubes);
    }
}
