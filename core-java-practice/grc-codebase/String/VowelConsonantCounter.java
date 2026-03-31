//Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string

import java.util.Scanner;

public class VowelConsonantCounter{

    // Method to check if a character is Vowel, Consonant, or Not a Letter
    public static String checkCharacter(char ch){
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // Check if character is a letter
        if(ch >= 'a' && ch <= 'z'){
            // Check vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }
    // Method to find vowels and consonants count
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String result = checkCharacter(text.charAt(i));
            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.nextLine();
        int[] result = countVowelsAndConsonants(text);
        System.out.println("\nVowels count: " + result[0]);
        System.out.println("Consonants count: " + result[1]);
        input.close();
    }
}
