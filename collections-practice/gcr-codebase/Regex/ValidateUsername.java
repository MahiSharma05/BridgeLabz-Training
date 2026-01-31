package Regex;
import java.util.Scanner;

public class ValidateUsername {
	
	// Check validation of userName
	public static boolean isValideUsername(String userName) {
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		return userName.matches(regex);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a username");
		String userName = input.nextLine();
		
		if(isValideUsername(userName)) {
			System.out.println(userName + " -> Valid");
		}
		else {
			System.out.println(userName + " -> Invalid");

		}
		input.close();
	}

}
