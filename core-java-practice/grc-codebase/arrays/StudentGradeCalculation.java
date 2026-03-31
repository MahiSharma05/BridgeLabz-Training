//Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade

import java.util.Scanner;

public class StudentGradeCalculation {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // input for number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // arrays
        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // input for marks with validation
        for(int i = 0; i < n; i++){
            System.out.println("\n Enter marks for Student " +(i + 1));

            System.out.println("Physics: ");
            physics[i] = input.nextDouble();

            System.out.println("Chemistry: ");
            chemistry[i] = input.nextDouble();

            System.out.println("Maths: ");
            maths[i] = input.nextDouble();

            // If negative marks, re-enter
            if(physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0){
                System.out.println("Invalid marks! Please enter positive values.");
                i--;
            }
        }
        // Calculate percentage and grade
        for(int i = 0; i < n; i++){
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 300 * 100;

            if(percentage[i] >= 80){
                grade[i] = 'A';
            } 
			else if(percentage[i] >= 70){
                grade[i] = 'B';
            } 
			else if(percentage[i] >= 60){
                grade[i] = 'C';
            }
			else if(percentage[i] >= 50){
                grade[i] = 'D';
            }
			else if(percentage[i] >= 40){
                grade[i] = 'E';
            } 
			else{
                grade[i] = 'R';
            }
        }
        // result
        System.out.println("\n STUDENT RESULT");
        for(int i = 0; i < n; i++){
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Maths: " + maths[i]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }
        input.close();
    }
}
