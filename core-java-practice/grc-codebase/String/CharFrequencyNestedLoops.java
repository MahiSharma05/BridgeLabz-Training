// Write a program to find the frequency of characters in a string using nested loops and display the result

import java.util.Scanner;

public class CharFrequencyNestedLoops {

    // Method to find frequency using nested loops
    public static String[] findFrequency(String text) {

        // Convert string to character array
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        // Find frequency using nested loops
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }
        // Count unique characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }
        // Create 1D String array for result
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[] frequency = findFrequency(text);

        // Display result
        System.out.println("Character Frequency:");
        for(String s : frequency) {
            System.out.println(s);
        }
        input.close();
    }
}
