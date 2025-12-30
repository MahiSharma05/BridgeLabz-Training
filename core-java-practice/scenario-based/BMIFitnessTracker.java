import java.util.Scanner;

public class BMIFitnessTracker {
    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Ask user for height in meters
        System.out.print("Enter height in meters: ");
        double height = input.nextDouble();

        // Ask user for weight in kilograms
        System.out.print("Enter weight in kilograms: ");
        double weight = input.nextDouble();

        // Calculate BMI using formula
        double bmi = weight / (height * height);

        // Display BMI value
        System.out.println("Your BMI is: " + bmi);

        // Determine BMI category using if-else
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }

        input.close();
    }
}
