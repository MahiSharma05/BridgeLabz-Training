//Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the percentage and then calculate the grade 

import java.util.Scanner;

public class PercentageAndGradeCalculation {

    //Generate random 2-digit PCM scores
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3]; 

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }
        return scores;
    }
    // Calculate total, average and percentage
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; 
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Calculate grade
    public static String[] calculateGrade(double[][] results) {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) {
            double percent = results[i][2];
            if (percent >= 80){
                grades[i] = "A";
			}	
            else if (percent >= 70){
                grades[i] = "B";
			}	
            else if (percent >= 60){
                grades[i] = "C";
			}	
            else if (percent >= 50){
                grades[i] = "D";
			}	
            else if (percent >= 40){
                grades[i] = "E";
			}	
            else{
                grades[i] = "R";
			}	
        }
        return grades;
    }

    // Display scorecard
    public static void displayScoreCard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("\nStudent Scorecard");
		System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");

        for (int i = 0; i < scores.length; i++){
            System.out.println((i + 1) + "\t" +scores[i][0] + "\t" +scores[i][1] + "\t" +scores[i][2] + "\t" +(int) results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + grades[i]);        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = input.nextInt();

        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrade(results);
        displayScoreCard(scores, results, grades);
        input.close();
    }
}
