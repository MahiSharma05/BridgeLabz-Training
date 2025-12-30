// Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods

import java.util.Arrays;

// Utility class
class NumberChecker3 {

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

    // Method to reverse a digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Method to check if number is palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }

    // Method to check if number is a Duck number
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) return true; // has non-zero digit
        }
        return false; // all zeros
    }
}

public class NumberChecker3Test {
    public static void main(String[] args) {
        int number = 121; // example number
        System.out.println("Number: " + number);

        // Count digits
        int digitCount = NumberChecker3.countDigits(number);
        System.out.println("Count of digits: " + digitCount);

        // Digits array
        int[] digits = NumberChecker3.getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        // Reverse digits array
        int[] reversed = NumberChecker3.reverseArray(digits);
        System.out.println("Reversed digits array: " + Arrays.toString(reversed));

        // Check if number is palindrome
        boolean palindrome = NumberChecker3.isPalindrome(number);
        System.out.println("Is Palindrome? " + palindrome);

        // Check if number is Duck number
        boolean duck = NumberChecker3.isDuckNumber(digits);
        System.out.println("Is Duck number? " + duck);
    }
}
