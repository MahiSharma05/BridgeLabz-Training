package ExceptionHandling;

import java.util.Scanner;

public class ThrowVsThrows {

	public static void calculateInteres(double amount, double rate, int years) throws IllegalArgumentException{
		if(amount <0 || rate < 0) {
			throw new IllegalArgumentException("Amount and rate must be positive");
		}
		else {
			double interest = (amount * rate * years) / 100;
			System.out.println("Interest : " + interest );
		}
	}	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
		    System.out.println("Enter Amount: ");
		    double amount = input.nextDouble();
		    System.out.println("Enter Rate: ");
		    double rate = input.nextDouble();
		    System.out.println("Enter Years: ");
		    int years = input.nextInt();
		    
		    calculateInteres(amount, rate, years);
		}
        
        catch(IllegalArgumentException  e) {
        	System.out.println(e.getMessage());
        }
		finally {
		input.close();
		}
	}

}
