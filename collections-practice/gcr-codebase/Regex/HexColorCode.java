package Regex;

import java.util.Scanner;

public class HexColorCode {
	
	// Check Validation Hex color code
		public static boolean isValidateColorCode(String colorCode) {
			String regex = "^[#][0-9A-Fa-f]{6}$";
			return colorCode.matches(regex);
		}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Hex color code: ");
		String colorCode = input.nextLine();
		
		if(isValidateColorCode(colorCode)) {
			System.out.println(colorCode + " is valid");
		}
		else {
			System.out.println(colorCode + " is invalid");
		}
		input.close();

	}

}

