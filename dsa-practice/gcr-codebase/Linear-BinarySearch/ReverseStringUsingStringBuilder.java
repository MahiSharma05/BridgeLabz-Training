package dsaPractice;

public class ReverseStringUsingStringBuilder {
	
	public static String reverseString(String input) {
		
		// StringBuilder object
		StringBuilder sb = new StringBuilder();
		
		// Append the input String
		sb.append(input);
		
		// Reverse String
		sb.reverse();
		
		// Convert Back to String 
		return sb.toString();
		
	}

	public static void main(String[] args) {
		String input = "hello";
		System.out.println("Original String: " + input);
		System.out.println("Reverse String: " + reverseString(input));

	}

}
