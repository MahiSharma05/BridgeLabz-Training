class PalindromeChecker {
    String text;

    // Constructor
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check palindrome
    boolean isPalindrome() {
        // Remove spaces and convert to lowercase
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = "";

        for (int i = cleanedText.length() - 1; i >= 0; i--) {
            reversed = reversed + cleanedText.charAt(i);
        }

        return cleanedText.equals(reversed);
    }

    // Method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}

public class Palindrome {
    public static void main(String[] args) {

        // First test case
        PalindromeChecker p1 =
                new PalindromeChecker("A man a plan a canal Panama");
        p1.displayResult();

        // Second test case
        PalindromeChecker p2 =
                new PalindromeChecker("Hello");
        p2.displayResult();
    }
}

