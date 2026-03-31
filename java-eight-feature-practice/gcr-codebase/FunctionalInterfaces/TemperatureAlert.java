package FunctionalInterfaces;
import java.util.Scanner;
import java.util.function.Predicate;

public class TemperatureAlert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double threshold = 40.0;

		System.out.println("Enter Temperature: ");
		double currentTemperature = input.nextDouble();

	        // Predicate to check if temperature crosses the threshold
	        Predicate<Double> temperatureAlert = temp -> temp > threshold;

	        // Check 
	        if (temperatureAlert.test(currentTemperature)) {
	            System.out.println("Alert! Temperature crossed the threshold.");
	        } else {
	            System.out.println("Temperature is normal.");
	        }
	        input.close();
	}

}
