package Program;
import java.util.*;

public class Program {
	
	public static String cleanseAndInvert(String input) {
		
		// Return null if String is null or less than 6
		if(input == null || input.length() < 6 ) {
			return "";
		}
		
		// Return null if string have space, digit or special character
		for(char ch : input.toCharArray()) {
			if(! Character.isLetter(ch)) {
				return "";
			}
		}
		
		// convert String into lowercase
		input = input.toLowerCase();
		
		// Remove all characters whose ASCII values are even numbers.
		StringBuilder filtered = new StringBuilder();
		for(char ch : input.toCharArray()) {
			if(!(ch % 2 == 0)) {
				filtered.append(ch);
			}
		}
		
		// Reverse the String
		filtered.reverse();
		
		// Convert even positioned character to Upper Case
		for(int i = 0; i < filtered.length(); i++) {
			if(i % 2 == 0) {
				filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
			}
		}
		return filtered.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String input = sc.nextLine();
		
		String result = cleanseAndInvert(input);
		
		// print invalid input if String is empty
		if(result.isEmpty()) {
			System.out.println("Invalid input");
		}
		
		// Print result
		else {
			System.out.println("The Generated key is: " + result);
		}
		sc.close();
	}

}
