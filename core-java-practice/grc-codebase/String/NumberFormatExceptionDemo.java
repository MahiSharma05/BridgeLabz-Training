//Write a program to demonstrate NumberFormatException


import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {

        // This will throw NumberFormatException if text is not numeric
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {

        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } 
		catch (NumberFormatException e){
            System.out.println("NumberFormatException caught!");
            System.out.println("Reason: Input string is not a valid number");
        } 
		catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught!");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String text = input.next();

        System.out.println("\nGenerating Exception:");
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(text);

        input.close();
    }
}
