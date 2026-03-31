package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {

    // Extract and print emails
    public static void extractEmails(String text) {

        String regex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {

        String text = "Contact us at support@example.com and info@company.org";

        extractEmails(text);
    }
}