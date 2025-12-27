//Write a program to split the text into words, compare the result with the split() method and display the result

import java.util.Scanner;

public class SplitText{

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } 
		catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text into words without using split()
    public static String[] splitUsingCharAt(String text) {
        int length = findLength(text);

        // Count words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndex = new int[wordCount + 1];
        int index = 0;
        spaceIndex[index++] = -1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }
        spaceIndex[index] = length;

        // Extract words
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }
    // Method to compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter text: ");
        String text = input.nextLine();

        // User-defined split
        String[] customWords = splitUsingCharAt(text);

        // Built-in split
        String[] builtInWords = text.split(" ");

        // Compare results
        boolean result = compareStringArrays(customWords, builtInWords);

        System.out.println("Words using user-defined method:");
        for (String word : customWords) {
            System.out.println(word);
        }
        System.out.println("Words using split() method:");
        for (String word : builtInWords) {
            System.out.println(word);
        }
        System.out.println("Are both results same? " + result);
        input.close();
    }
}
