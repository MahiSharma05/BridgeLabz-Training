//Create a program to find the BMI of a person

import java.util.Scanner;

public class BMICalculator{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weight in kg:");
        double weight = input.nextDouble();

        System.out.print("Enter your height in cm:");
        double heightCm = input.nextDouble();

        // Convert height from cm to meters
        double heightMeter = heightCm / 100;

        // Calculate BMI
        double bmi = weight / (heightMeter * heightMeter);

        // Display BMI
        System.out.println("Your BMI is: "+ bmi);

        // Determine weight status
        if(bmi <= 18.4){
            System.out.println("Status: Underweight");
        } 
        else if(bmi >= 18.5 && bmi <= 24.9){
            System.out.println("Status: Normal");
        } 
        else if(bmi >= 25.0 && bmi <= 39.9){
            System.out.println("Status: Overweight");
        } 
        else{
            System.out.println("Status: Obese");
        }
        input.close();
    }
}
