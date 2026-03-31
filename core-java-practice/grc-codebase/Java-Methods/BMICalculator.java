// An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the team of 10 members. For this create a program to find the BMI and display the height, weight, BMI and status of each individual

import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 2D Array: 10 rows, 3 columns
        // column 0 -> weight
        // column 1 -> height
        // column 2 -> BMI
        double[][] personData = new double[10][3];
        String[] bmiStatus = new String[10];

        // Taking input
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            personData[i][0] = input.nextDouble();

            System.out.print("Enter height (cm): ");
            personData[i][1] = input.nextDouble();

            // Calculate BMI
            personData[i][2] = calculateBMI(personData[i][0], personData[i][1]);

            // Determine BMI status
            bmiStatus[i] = getBMIStatus(personData[i][2]);
        }

        //  Result
        System.out.println("\n------ BMI REPORT ------");
        System.out.println("Person\tWeight\tHeight\tBMI\t\tStatus");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n",
                    (i + 1),
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    bmiStatus[i]);
        }

        input.close();
    }
	
	// Method to calculate BMI
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightMeter = heightCm / 100;   // convert cm to meter
        return weightKg / (heightMeter * heightMeter);
    }

    // Method to determine BMI Status
    public static String getBMIStatus(double bmi) {

        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
