package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinksExtractor {
	// Extract and print Dates
    public static void extracLinks(String text) {

        String regex = "https?://[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(/[^\\s]*)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {

        String text = "Visit https://www.google.com and http://example.org for more info.";


        extracLinks(text);
    }
}


