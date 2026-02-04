package FunctionalInterfaces;
import java.util.function.*;
import java.util.Scanner;

public class StringLengthChecker {

	public static void main(String[] args) {
	        int limit = 20;
	        Scanner input = new Scanner(System.in);
	        System.out.println("Enetr message:");
	        String text = input.nextLine();

	        // Function to calculate length of a string
	        Function<String, Integer> stringLength = message -> message.length();

	        // find length using Function
	        int length = stringLength.apply(text);

	        // check against limit
	        if (length > limit) {
	            System.out.println("Message exceeds the character limit.");
	        } else {
	            System.out.println("Message is within the character limit.");
	        }

	        // Optional: print length
	        System.out.println("Message Length: " + length);
	        input.close();
	}

}
