package ExceptionHandling;

import java.util.*;

public class UncheckedException {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter first Number: ");
			int num1 = input.nextInt();
			System.out.println("Enter Second Number: ");
			int num2 = input.nextInt();
			
			// Calculate result
			int result = num1 / num2;
		}
		catch(ArithmeticException e) {
			System.out.println("Number not divided by zero.");
		}
		catch(InputMismatchException e) {
			System.out.println("Error: Enter integer values");
		}
		finally {
			input.close();
		}
	}

}
