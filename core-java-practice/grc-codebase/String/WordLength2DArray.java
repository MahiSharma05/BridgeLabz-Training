//Write a program to split the text into words and return the words along with their lengths in a 2D array

import java.util.Scanner;

public class WordLength2DArray{

    // Method to find length of string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } 
		catch (StringIndexOutOfBoundsException e){
            return count;
        }
    }
    // Method to split text into words using charAt()
    public static String[] splitIntoWords(String text) {
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
        int idx = 0;
        spaceIndex[idx++] = -1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }
        spaceIndex[idx] = length;
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
    // Method to create 2D array of word and its length
    public static String[][] createWordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitIntoWords(text);
        String[][] wordLengthArray = createWordLengthArray(words);
        System.out.println("Word\tLength");
        for (int i = 0; i < wordLengthArray.length; i++){
            String word = wordLengthArray[i][0];
            int length = Integer.parseInt(wordLengthArray[i][1]);
            System.out.println(word + "\t" + length);
        }
        input.close();
    }
}
