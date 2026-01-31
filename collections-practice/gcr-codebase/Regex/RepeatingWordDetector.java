package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWordDetector {

    // Find repeating words
    public static void findRepeatingWords(String text) {

        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    public static void main(String[] args) {

        String input = "This is is a repeated repeated word test.";
        findRepeatingWords(input);
    }
}
