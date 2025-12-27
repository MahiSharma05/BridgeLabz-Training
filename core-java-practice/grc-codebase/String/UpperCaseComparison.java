//Write a program to convert the complete text to uppercase and compare the results


import java.util.Scanner;

public class UpperCaseComparison {

    // Method to convert text to uppercase using charAt() and Ascii logic
    public static String convertToUpperCase(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is lowercase (a-z)
            if (ch >= 'a' && ch <= 'z'){
			    // ASCII conversion
                ch = (char) (ch - 32); 
            }

            result = result + ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()){
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

        System.out.print("Enter complete text: ");
        String text = input.nextLine();

        // User-defined uppercase conversion
        String customUpper = convertToUpperCase(text);

        // Built-in uppercase conversion
        String builtInUpper = text.toUpperCase();

        // Compare both results
        boolean isSame = compareStrings(customUpper, builtInUpper);

        System.out.println("\nUppercase using user-defined method: " + customUpper);
        System.out.println("Uppercase using toUpperCase(): " + builtInUpper);
        System.out.println("Are both results same? " + isSame);

        input.close();
    }
}
