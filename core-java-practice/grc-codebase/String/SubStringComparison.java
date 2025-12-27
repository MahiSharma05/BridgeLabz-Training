import java.util.Scanner;

public class SubStringComparison {

    // Method to create substring using charAt()
    public static String substringUsingCharAt(String str, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareString(String str1, String str2) {

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

        System.out.println("Enter string: ");
        String str = input.next();

        System.out.println("Enter Starting index: ");
        int start = input.nextInt();

        System.out.println("Enter ending index: ");
        int end = input.nextInt();

        // Correct variable types (String)
        String resultCharAt = substringUsingCharAt(str, start, end);
        String resultSubString = str.substring(start, end);

        boolean isSame = compareString(resultCharAt, resultSubString);

        System.out.println("Substring using charAt(): " + resultCharAt);
        System.out.println("Substring using substring(): " + resultSubString);
        System.out.println("Are both substrings equal? " + isSame);

        input.close();
    }
}
