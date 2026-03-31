// Write a program to to check if a text is palindrome and display the result


import java.util.Scanner;

public class Palindrome {

    // Using start and end comparison (loop)
    public static boolean isPalindromeLoop(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Using recursion
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Method to reverse string using charAt()
    public static char[] reverseString(String text) {
        char[] reverse = new char[text.length()];
        int index = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }
        return reverse;
    }
    // Using character arrays
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.nextLine();

        System.out.println("Using Loop Logic: " +(isPalindromeLoop(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using Recursive Logic: " + (isPalindromeRecursive(text, 0, text.length() - 1)
                        ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using Character Array Logic: " + (isPalindromeArray(text) ? "Palindrome" : "Not Palindrome"));
        input.close();
    }
}
