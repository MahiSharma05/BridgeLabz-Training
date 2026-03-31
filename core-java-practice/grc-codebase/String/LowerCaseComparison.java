//Write a program to convert the complete text to lowercase and compare the results

import java.util.Scanner;

public class LowerCaseComparison {

    // Method to convert text to lowercase using charAt() and ASCII logic
    public static String convertToLowerCase(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is uppercase (A-Z)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // ASCII conversion
            }
            result = result + ch;
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter complete text: ");
        String text = input.nextLine();

        // User-defined lowercase conversion
        String customLower = convertToLowerCase(text);

        // Built-in lowercase conversion
        String builtInLower = text.toLowerCase();

        // Compare both results
        boolean isSame = compareStrings(customLower, builtInLower);

        System.out.println("\nLowercase using user-defined method: " + customLower);
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);
        System.out.println("Are both results same? " + isSame);

        input.close();
    }
}
