package Regex;
import java.util.Scanner;

public class LicensePlateNumber {
	
	// Check Validation of license plate number
	public static boolean isValidatePlateNumber(String plateNumber) {
		String regex = "^[A-Z]{2}[0-9]{4}$";
		return plateNumber.matches(regex);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter License Plate Number: ");
		String plateNumber = input.nextLine();
		
		if(isValidatePlateNumber(plateNumber)) {
			System.out.println(plateNumber + " is valid");
		}
		else {
			System.out.println(plateNumber + " is invalid");
		}
		input.close();

	}

}
