import java.util.Arrays;

// Utility class
class NumberChecker4 {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;
        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int n = number;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return sum == product;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String strNum = Integer.toString(number);
        String strSquare = Integer.toString(square);
        return strSquare.endsWith(strNum);
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}

// Test class
public class NumberChecker4Test {
    public static void main(String[] args) {
        int[] numbers = {7, 9, 5, 1, 153}; // Example numbers

        for (int number : numbers) {
            System.out.println("Number: " + number);

            System.out.println("Is Prime? " + NumberChecker4.isPrime(number));
            System.out.println("Is Neon Number? " + NumberChecker4.isNeonNumber(number));
            System.out.println("Is Spy Number? " + NumberChecker4.isSpyNumber(number));
            System.out.println("Is Automorphic? " + NumberChecker4.isAutomorphic(number));
            System.out.println("Is Buzz Number? " + NumberChecker4.isBuzzNumber(number));
            System.out.println("-------------------------------------");
        }
    }
}
