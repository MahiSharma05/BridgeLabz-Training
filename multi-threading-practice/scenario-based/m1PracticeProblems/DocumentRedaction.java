package practice2;
import java.util.*;
public class DocumentRedaction {
	public static String validateDocument(String input) {
		input = input.replaceAll("ID:[A-Z]{3}\\d{6}", "ID:XXX******");
		input = input.replaceAll("ACCT-\\d{4}-\\d{4}-(\\d{4})", "ACCT---$1");
		input = input.replaceAll("(?i)\\b(\\w+)\\b\\s+\\b\\1\\b", "$1");
		input = input.replaceAll("([?!\\.])\\1{2,}", "$1");
		return input;
	}
	public static void main(String[] args) {
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			System.out.println(validateDocument(input));
		}
	}
}
