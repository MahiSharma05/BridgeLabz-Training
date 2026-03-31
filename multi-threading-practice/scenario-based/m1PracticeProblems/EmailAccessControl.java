package practice;
import java.util.*;
public class EmailAccessControl {
	public static boolean validateEmail(String input) {
			if(!input.matches("^[a-z]{3,}\\.[a-z]{3,}[0-9]{4,}@(sales|marketing|IT|product)\\.company\\.com$")){
				return false;
			}
			return true;
		}
	
	public static void main(String[] args) {
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
	      String input  = sc.nextLine();
	       if(validateEmail(input)) {
		       System.out.println("Access Granted");
	       }
	       else {
		       System.out.println("Access Denied");
	       }
	    }
   	}
}
