package dsaPractice;

public class ConcatenateStrings {
	
	public static String concatenateStrings(String[] words) {
		// StringBuffer object
		StringBuffer sb = new StringBuffer();
		
		// Append each string to stringBuffer
		for(String word : words) {
			sb.append(word);
		}
		
		// convert StringBuffer to String and return
		return sb.toString()
;	}

	public static void main(String[] args) {
		String[] input = {"Java", " ", "is", " ","a", " ", "Programming", " ", "language"};
        System.out.println("Concatenated String: " + concatenateStrings(input));
    }
}