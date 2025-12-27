//Write a program to demonstrate ArrayIndexOutOfBoundsException

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names){

        // Accessing index beyond array length
        System.out.println("Name: " + names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {

        try {
            // Accessing index beyond array length
            System.out.println("Name: " + names[names.length]);
        } 
		catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
            System.out.println("Reason: Invalid index access in the array");
        } 
		catch (RuntimeException e) {
            System.out.println(" RuntimeException caught");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = input.nextInt();

        String[] names = new String[n];

        for(int i = 0; i < n; i++){
            System.out.println("Enter name " + (i + 1) + ": ");
            names[i] = input.next();
        }

        System.out.println("\nGenerating Exception:");
        try {
            generateException(names);
        }
		catch (RuntimeException e) {
            System.out.println("Exception occurred in generateException()");
        }

        System.out.println("\nHandling Exception:");
        handleException(names);

        input.close();
    }
}
