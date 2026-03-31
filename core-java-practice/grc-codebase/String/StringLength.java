//Write a program to find and return the length of a string without using the length() method 

import java.util.Scanner;

public class StringLength{

    // User-defined method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); 
                count++;
            }
        }
		catch(StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.next();

        // User-defined method
        int customLength = findLength(text);

        // Built-in method
        int builtInLength = text.length();

        System.out.println("\nLength using user-defined method: " + customLength);
        System.out.println("Length using built-in length(): " + builtInLength);

        input.close();
    }
}
