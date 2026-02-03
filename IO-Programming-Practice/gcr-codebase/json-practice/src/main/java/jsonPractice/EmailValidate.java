package jsonPractice;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailValidate {
	public static boolean isValidEmail(String email) {
        try {      
    		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";
            return email.matches(regex);
            
        } 
        catch (Exception e) {
            System.out.println("Invalid email syntax: ");
            return false;
        }
    }
	public static void main(String[] args) {
		String email = "{\"email\":mahi123}";
        System.out.println("Valid Email: " + isValidEmail(email));
	}
	
	

}
