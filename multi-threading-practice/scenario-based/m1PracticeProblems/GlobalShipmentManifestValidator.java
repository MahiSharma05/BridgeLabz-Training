package practice;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;
public class GlobalShipmentManifestValidator {
	
	public static boolean validateCode(String code) {
		if(! code.matches("SHIP-[1-9](?!.*([0-9])\\1{3})[0-9]{5}")) {
			return false;
		}
		return true;
	}
	
	public static boolean validateDate(String date) {
		if(!date.matches("^20[0-9]{2}-[0-9]{2}-[0-9]{2}$")) {
			return false;
		}
		try {
			LocalDate.parse(date);
			return true;
		}
		catch(Exception e) {
			return false;
		}	
	}
	
	public static boolean validateMode(String mode) {
		if(!mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT")){
			return false;
		}
		return true;
	}
	
	public static boolean validateWeight(String weight) {
		if(!weight.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?")){
			return false;
		}
		double w = Double.parseDouble(weight);
		
		return w > 0 && w <= 999999.99;
		
	}    
	
	public static boolean validateStatus(String status) {
		if(!status.matches("DELIVERED|CANCELLED|IN_TRANSIT")) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Enter no of inputs");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] data = input.split("\\|");
			String code = data[0];
			String date = data[1];
			String mode = data[2];
			String weight = data[3];
			String status = data[4];
			if(validateCode(code) && validateDate(date) && validateMode(mode) && validateWeight(weight) && validateStatus(status)) {
				System.out.println();
				System.out.println("COMPLIANT RECORD");
			}
			else {
				System.out.println("NON-COMPLIANT RECORD");

			}
		}

	}

}
