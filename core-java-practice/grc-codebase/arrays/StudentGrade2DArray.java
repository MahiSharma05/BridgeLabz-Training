//Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade using  2D array 

import java.util.Scanner;

public class StudentGrade2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //input for number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        // 2D array for marks
        double[][] marks = new double[n][3]; 
        double[] percentage = new double[n];
        char[] grade = new char[n];

        //input for marks with validation
        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));
            System.out.print("Physics: ");
            marks[i][0] = input.nextDouble();
            System.out.print("Chemistry: ");
            marks[i][1] = input.nextDouble();
            System.out.print("Maths: ");
            marks[i][2] = input.nextDouble();

            // If any mark is negative, re-enter
            if(marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Invalid marks! Enter positive values only.");
                i--; 
            }
        }
        //Calculate percentage and grade
        for(int i = 0; i < n; i++) {
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 300 * 100;
            if(percentage[i] >= 80) {
                grade[i] = 'A';
            } 
			else if (percentage[i] >= 70){
                grade[i] = 'B';
            } 
			else if (percentage[i] >= 60){
                grade[i] = 'C';
            } 
			else if (percentage[i] >= 50){
                grade[i] = 'D';
            } 
			else if (percentage[i] >= 40){
                grade[i] = 'E';
            } 
			else {
                grade[i] = 'R';
            }
        }

        // Display result
        System.out.println("\n   STUDENT RESULT   ");
        for(int i = 0; i < n; i++){
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }
        input.close();
    }
}

