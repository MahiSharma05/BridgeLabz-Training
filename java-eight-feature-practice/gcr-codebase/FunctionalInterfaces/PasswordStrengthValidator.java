package FunctionalInterfaces;
import java.util.*;

// SecurityUtils interface
interface SecurityUtils{
	// validate password
	 static boolean isValidePassword(String password) {
	     String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		return password.matches(regex);
	}
}
public class PasswordStrengthValidator {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enetr Password: ");
		String password = input.nextLine();
		
		// call static method
		if(SecurityUtils.isValidePassword(password)){
			System.out.println("Strong password");
		}
		else{
			System.out.println("Weak password");
			
		}
		input.close();
	}
}
