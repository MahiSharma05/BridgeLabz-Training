//Write a program to split the text into words and find the shortest and longest strings in a given text

import java.util.Scanner;

public class ShortestLongestWord {
    // Method to find length of string without using length()
    public static int findLength(String text){
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
    // Method to split text into words using charAt
    public static String[] splitIntoWords(String text){
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
        for(int i = 0; i < length; i++){
            if(text.charAt(i) == ' '){
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

        String[][] data = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(findLength(words[i]));
        }

        return data;
    }
    // Method to find shortest and longest word index
    public static int[] findShortestAndLongest(String[][] data) {

        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < data.length; i++) {
            int length = Integer.parseInt(data[i][1]);

            if (length < Integer.parseInt(data[shortestIndex][1])) {
                shortestIndex = i;
            }

            if (length > Integer.parseInt(data[longestIndex][1])) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitIntoWords(text);
        String[][] wordData = createWordLengthArray(words);

        int[] result = findShortestAndLongest(wordData);

        System.out.println("\nWord\tLength");
        for (int i = 0; i < wordData.length; i++) {
            System.out.println(wordData[i][0] + "\t" + wordData[i][1]);
        }
        System.out.println("\nShortest Word: " + wordData[result[0]][0] + " (" + wordData[result[0]][1] + ")");

        System.out.println("Longest Word: " + wordData[result[1]][0]+ " (" + wordData[result[1]][1] + ")");
        input.close();
    }
}
