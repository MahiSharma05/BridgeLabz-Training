//Write a program to find the first non-repeating character in a string and show the result

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find first non-repeating character
    public static char findFirstNonRepeating(String text) {

        int[] freq = new int[256]; // ASCII frequency array

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }
        return '\0'; 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char result = findFirstNonRepeating(text);
        if (result != '\0') {
            System.out.println("First non-repeating character is: " + result);
        }
		else {
            System.out.println("No non-repeating character found.");
        }
        input.close();
    }
}
