import java.util.Arrays;

// Utility class
class NumberChecker5 {

    // Method to calculate sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        return sumOfProperDivisors(number) == number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        return sumOfProperDivisors(number) > number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        return sumOfProperDivisors(number) < number;
    }

    // Method to calculate factorial of a number
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int n = number;
        while (n != 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }
        return sum == number;
    }
}

// Test class
public class NumberChecker5Test {
    public static void main(String[] args) {
        int[] numbers = {6, 12, 8, 145, 28}; // Example numbers

        for (int number : numbers) {
            System.out.println("Number: " + number);
            System.out.println("Is Perfect Number? " + NumberChecker5.isPerfectNumber(number));
            System.out.println("Is Abundant Number? " + NumberChecker5.isAbundantNumber(number));
            System.out.println("Is Deficient Number? " + NumberChecker5.isDeficientNumber(number));
            System.out.println("Is Strong Number? " + NumberChecker5.isStrongNumber(number));
            System.out.println("--------------------------------------");
        }
    }
}
