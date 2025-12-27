//Write a program to check if two texts are anagrams and display the result


import java.util.Scanner;

public class Anagram {

    // Method to check if two texts are anagrams
    public static boolean isAnagram(String text1, String text2) {

        // Check length
        if (text1.length() != text2.length()) {
            return false;
        }

        // Frequency arrays for 256 ASCII characters
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Find frequency of characters
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = input.nextLine();

        System.out.print("Enter second text: ");
        String text2 = input.nextLine();

        if (isAnagram(text1, text2)) {
            System.out.println("The texts are Anagrams.");
        } 
		else {
            System.out.println("The texts are NOT Anagrams.");
        }
        input.close();
    }
}
