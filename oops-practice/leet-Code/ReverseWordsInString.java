//Problem 151: Reverse Words in a String

package leetCode;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String input = "  hello   world  ";
        String output = reverseWords(input);

        System.out.println("Output: " + output);

	}
	public static String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();

        // Split words by one or more spaces
        String[] words = s.split("\\s+");

        // Reverse words
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
