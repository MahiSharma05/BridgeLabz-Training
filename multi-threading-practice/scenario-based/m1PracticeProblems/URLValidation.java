package practice2;
import java.util.*;
public class URLValidation {
	static HashSet<String> duplicate = new HashSet<>();
 
	public static String validateURL(String input) {
		if(!(input.contains("://") && input.contains("."))) {
			return "INVALID URL : format is invalid";
		}
		if(!(input.startsWith("http://") || input.startsWith("https://"))){
			return "INVALID URL : protocol is invalid";
		}
		String temp = input.substring(input.indexOf("://")+3);
		String[] parts = temp.split("\\.");
		if(parts.length != 2) {
			return "INVALID URL : format is invalid";
		}
		String website = parts[0];
		String domain = parts[1];
		
		if(!website.matches("^[a-z]{1,10}$")) {
			return "INVLID URL : website name is invalid";
		}
		if(!domain.matches("(com|co|in|org|gov)")) {
			return "INVALID URL : domain is invalid";
		}
		if(duplicate.contains(input)) {
			return " Duplicate url found";
		}
		duplicate.add(input);
		return "valid url";
	}

	public static void main(String[] args) {
		System.out.println("input");  
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine().trim();
			System.out.println(validateURL(input));
		}
	}
}
