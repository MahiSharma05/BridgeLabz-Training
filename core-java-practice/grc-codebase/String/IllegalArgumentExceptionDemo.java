//Write a program to demonstrate IllegalArgumentException

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Method to generate IllegalArgumentException
    public static void generateException(String text) {

        // Start index is greater than end index
        System.out.println("Substring: " + text.substring(4, 1));
    }

    // Method to handle IllegalArgumentException
    public static void handleException(String text) {

        try {
            // Start index is greater than end index
            System.out.println("Substring: " + text.substring(4, 1));
        } 
		catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught!");
            System.out.println("Reason: Start index is greater than end index");
        }
		catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught!");
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.next();

        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } 
		catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(text);

        input.close();
    }
}
