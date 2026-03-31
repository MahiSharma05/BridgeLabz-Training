package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSocialSecurityNumber {

    // Extract and validate SSN
    public static void validateSSN(String text) {

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("❌ No valid SSN found");
        }
    }

    public static void main(String[] args) {

        String text1 = "My SSN is 123-45-6789.";
        String text2 = "My SSN is 123456789.";
        validateSSN(text1);
        validateSSN(text2);
    }
}
