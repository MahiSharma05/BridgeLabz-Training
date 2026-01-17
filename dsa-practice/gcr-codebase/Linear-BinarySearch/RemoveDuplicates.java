package dsaPractice;
import java.util.HashSet;

public class RemoveDuplicates {
	
	public static String removeDuplication(String input) {
		
		// StringBuilder
		StringBuilder result = new StringBuilder();
		
		// HashSet to track character
		HashSet<Character> seen = new HashSet<>();
		
		// Iterate through each character
		for(char ch : input.toCharArray()) {
			if(!seen.contains(ch)) {
				seen.add(ch);
				result.append(ch);
			}
		}
		
		// Convert StringBuilder to String
		return result.toString();
		
	}

	public static void main(String[] args) {
		String input = "programming";
		System.out.println("Original String: " + input);
		System.out.println("Remove Duplication: " + removeDuplication(input));

	}

}
