
//Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method.
import java.util.Scanner;

public class StringComparison {

	public static boolean CompareStringUsingCharAt(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter first string: ");
		String str1 = input.next();

		System.out.println("Enter second string: ");
		String str2 = input.next();

		boolean resultCharAt = CompareStringUsingCharAt(str1, str2);
		boolean resultEquals = str1.equals(str2);

		System.out.println(" Comapre using charAt() " + resultCharAt);
		System.out.println(" Comapre using resultEquals() " + resultEquals);

		if (resultCharAt == resultEquals) {
			System.out.println("Both methods give the same result");
		} else {
			System.out.println("Both methods give the different result");
		}
		input.close();
	}
}
