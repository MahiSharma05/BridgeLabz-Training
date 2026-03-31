//Write a program to find the frequency of characters in a string using the charAt() method and display the result

import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency and return 2D array
    public static int[][] findFrequency(String text) {

        // Frequency array for 256 ASCII characters
        int[] freq = new int[256];

        // Find frequency using charAt()
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count number of unique characters
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }
        //  Create 2D array to store character and frequency
        int[][] result = new int[count][2];
        int index = 0;

        // Store character ASCII value and frequency
        for (int i = 0; i < 256; i++) {
            if(freq[i] > 0) {
                result[index][0] = i;      
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int[][] frequency = findFrequency(text);

        // Display result
        System.out.println("Character Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println((char) frequency[i][0] + " : " + frequency[i][1]);
        }
        input.close();
    }
}
