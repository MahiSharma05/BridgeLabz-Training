//An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members. For this create a program to find the BMI and display the height, weight, BMI, and status of each individual

import java.util.Scanner;

public class BMICalculator {
    // Method to calculate BMI and Status
    public static String[][] calculateBMIAndStatus(double weightKg, double heightCm) {
        String[][] result = new String[1][2];

        double heightMeter = heightCm / 100.0;
        double bmi = weightKg / (heightMeter * heightMeter);

        // round to 2 decimals
        bmi = Math.round(bmi * 100.0) / 100.0; 

        String status;
        if (bmi <= 18.4){
            status = "Underweight";
		}	
        else if (bmi <= 24.9){
            status = "Normal";
		}	
        else if (bmi <= 39.9){
            status = "Overweight";
		}	
        else{
            status = "Obese";
        }
        result[0][0] = String.valueOf(bmi);
        result[0][1] = status;
        return result;
    }

    //  Method to process all persons
    public static String[][] processPersons(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            String[][] bmiData = calculateBMIAndStatus(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0][0];
            result[i][3] = bmiData[0][1];
        }
        return result;
    }

    // Method to display results
    public static void displayResult(String[][] data) {

        System.out.println("\nBMI Report");
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" +  data[i][1] + "\t\t" + data[i][2] + "\t" + data[i][3] );
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double[][] inputData = new double[10][2];
        for(int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Enter weight in kg: ");
            inputData[i][0] = input.nextDouble();

            System.out.print("Enter height in cm: ");
            inputData[i][1] = input.nextDouble();
        }
        String[][] result = processPersons(inputData);
        displayResult(result);
        input.close();
    }
}
