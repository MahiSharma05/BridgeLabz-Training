// Create a program to take input marks of students in 3 subjects: physics, chemistry, and maths. Compute the total, average, and the percentage score

import java.util.Scanner;

public class StudentScoreCard {

    // Method to generate random 2-digit PCM marks
    public static int[][] generatePCMMarks(int students) {
        int[][] marks = new int[students][3]; // Physics, Chemistry, Maths

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int)(Math.random() * 90) + 10; // 10 to 99
            }
        }
        return marks;
    }

    // Method to calculate total, average and percentage
    public static double[][] calculateResult(int[][] marks) {
        int students = marks.length;
        double[][] result = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    // Method to get grade based on percentage
    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    // Method to display scorecard
    public static void displayScoreCard(int[][] marks, double[][] result) {

        System.out.println("\nSTUDENT SCORE CARD");
        System.out.println("---------------------------------------------------------------");
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\t%age\tGrade");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            double percentage = result[i][2];

            System.out.println(
                (i + 1) + "\t" +
                marks[i][0] + "\t" +
                marks[i][1] + "\t\t" +
                marks[i][2] + "\t" +
                (int)result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2] + "\t" +
                getGrade(percentage)
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        int[][] pcmMarks = generatePCMMarks(students);
        double[][] results = calculateResult(pcmMarks);
        displayScoreCard(pcmMarks, results);

        input.close();
    }
}
