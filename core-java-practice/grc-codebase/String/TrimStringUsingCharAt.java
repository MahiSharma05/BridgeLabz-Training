//Write a program to trim the leading and trailing spaces from a string using the charAt() method

import java.util.Scanner;

public class TrimStringUsingCharAt{
    // Method to find start and end index without leading/trailing spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' '){
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' '){
            end--;
        }
        return new int[] { start, end };
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end){
        String result = "";

        for (int i = start; i <= end; i++){
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        // User-defined trim logic
        int[] indexes = findTrimIndexes(text);
        String trimmedByUser = createSubstring(text, indexes[0], indexes[1]);

        // Built-in trim()
        String trimmedByBuiltIn = text.trim();

        // Compare results
        boolean isSame = compareStrings(trimmedByUser, trimmedByBuiltIn);

        // Display result
        System.out.println("\nTrimmed (User Method): \"" + trimmedByUser + "\"");
        System.out.println("Trimmed (Built-in trim): \"" + trimmedByBuiltIn + "\"");
        System.out.println("Are both strings equal? " + isSame);
        sc.close();
    }
}
