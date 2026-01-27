package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class finallyBlockExecution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter first Number: ");
			int num1 = input.nextInt();
			System.out.println("Enter Second Number: ");
			int num2 = input.nextInt();
			
			// Calculate result
			int result = num1 / num2;
			System.out.println("Result: " + result);
		}
		catch(ArithmeticException e) {
			System.out.println("Number not divided by zero.");
		}
		catch(InputMismatchException e) {
			System.out.println("Error: Enter integer values");
		}
		finally {
			System.out.println("Operation completed");
			input.close();
		}

	}

}
