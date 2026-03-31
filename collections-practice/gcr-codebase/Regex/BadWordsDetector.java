package Regex;

public class BadWordsDetector {

    // Detect bad words
    public static String censorBadWords(String text) {

        String regex = "\\b(damn|stupid)\\b";

        // Replace bad words with ****
        return text.replaceAll(regex, "****");
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String output = censorBadWords(input);
        System.out.println(output);
    }
}