package practice;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DynamicTemplateProcessor {
	public static String processPlaceholder(String content) {

        if (!content.contains(":"))
            return "INVALID";

        String[] parts = content.split(":", 2);
        String type = parts[0];
        String value = parts[1];

        try {

            switch (type) {

                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "DATE":
                    DateTimeFormatter input = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate date = LocalDate.parse(value, input);
                    DateTimeFormatter output = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    return date.format(output);

                case "REPEAT":
                    String[] v = value.split(",");
                    String word = v[0];
                    int count = Integer.parseInt(v[1]);

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < count; i++)
                        sb.append(word);

                    return sb.toString();

                default:
                    return "INVALID";
            }

        } catch (Exception e) {
            return "INVALID";
        }
    }

	public static void main(String[] args) {
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                String content = matcher.group(1);
                String replacement = processPlaceholder(content);
                matcher.appendReplacement(result, replacement);
            }

            matcher.appendTail(result);

            System.out.println(result.toString());
        }

        sc.close();

	}

}
