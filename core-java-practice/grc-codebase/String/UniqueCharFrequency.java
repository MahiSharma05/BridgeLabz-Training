//Write a program to find the frequency of characters in a string using unique characters and display the result

import java.util.Scanner;

public class UniqueCharFrequency {

    // Method to find unique characters using nested loops
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[count] = ch;
                count++;
            }
        }

        // Create exact size array
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }
    // Method to find frequency and return 2D String array
    public static String[][] findFrequency(String text) {

        // Frequency array for 256 ASCII characters
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        // Get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // 2D array to store character and frequency
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();
        String[][] frequency = findFrequency(text);
        System.out.println("Character Frequency:");
        for(int i = 0; i < frequency.length; i++) {
            System.out.println(frequency[i][0] + " : " + frequency[i][1]);
        }
        input.close();
    }
}
