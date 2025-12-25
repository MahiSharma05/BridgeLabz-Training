//An organization took up an exercise to find the Body Mass Index (BMI) of all the persons in the team. For this create a program to find the BMI and display the height, weight, BMI and status of each individual using multi-dimensional array

import java.util.Scanner;

public class BMI2DArrayCalculation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // input for number of persons
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        // 2D array(weight, height, BMI)
        double[][] personData = new double[number][3];

        // Array to store weight status
        String[] weightStatus = new String[number];

        // input for weight and height with validation
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person "+ (i + 1));

            // Weight input
            while(true) {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = input.nextDouble();
                if(personData[i][0] > 0)
                    break;
                System.out.println("Invalid input! Weight must be positive.");
            }
            // Height input
            while(true) {
                System.out.print("Enter height (meters): ");
                personData[i][1] = input.nextDouble();
                if(personData[i][1] > 0)
                    break;
                System.out.println("Invalid input! Height must be positive.");
            }
        }

        // Calculate BMI and determine status
        for(int i = 0; i < number; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            if(personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } 
			else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            }
			else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            }
			else {
                weightStatus[i] = "Obese";
            }
        }
        // display result
        System.out.println("\n    BMI DETAILS     ");
        for(int i = 0; i < number; i++){
            System.out.println("Person " + (i + 1));
            System.out.println("Weight: " + personData[i][0] +" kg");
            System.out.println("Height: " + personData[i][1] +" m");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }
        input.close();
    }
}

