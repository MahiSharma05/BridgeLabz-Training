// Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods


import java.util.Arrays;

class NumberChecker2 {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        int count = 0;
        int n = number;
        if (n == 0) return 1; // edge case
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    // Method to store digits in an array
    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int n = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    // Method to find the sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Method to find the sum of squares of digits
    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // Method to check if the number is a Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    // Method to find frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2]; // 0-9 digits
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i; // store digit
            freq[i][1] = 0; // initialize frequency
        }

        for (int d : digits) {
            freq[d][1]++;
        }

        return freq;
    }
}

public class NumberChecker2Test {
    public static void main(String[] args) {
        int number = 21; // example number
        System.out.println("Number: " + number);

        // Count digits
        int digitCount = NumberChecker2.countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        // Digits array
        int[] digits = NumberChecker2.getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        // Sum of digits
        int sumDigits = NumberChecker2.sumOfDigits(digits);
        System.out.println("Sum of digits: " + sumDigits);

        // Sum of squares of digits
        int sumSquares = NumberChecker2.sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumSquares);

        // Harshad number check
        boolean isHarshad = NumberChecker2.isHarshadNumber(number, digits);
        System.out.println("Is Harshad number? " + isHarshad);

        // Digit frequency
        int[][] freq = NumberChecker2.digitFrequency(digits);
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0) {
                System.out.println("Digit " + freq[i][0] + ": " + freq[i][1]);
            }
        }
    }
}
