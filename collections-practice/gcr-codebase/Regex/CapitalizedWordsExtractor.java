package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordsExtractor {

	// Extract and print Capitalized Words
    public static void extractWords(String text) {

        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {

        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";


        extractWords(text);
    }
}