package scenario;

import java.util.Scanner;

public class StudentScoreManager {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n;

        // Validate number of students
        if (!input.hasNextInt() || (n = input.nextInt()) <= 0) {
            System.out.println("Invalid number of students.");
            return;
        }

        int[] scores = new int[n];
        int sum = 0;

        // Input scores with validation
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score of student " + (i + 1) + ": ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                return;
            }

            int score = input.nextInt();

            if (score < 0) {
                System.out.println("Invalid score! Score cannot be negative.");
                return;
            }

            scores[i] = score;
            sum += score;
        }

        // Calculate average
        double average = (double) sum / n;

        // Find highest and lowest
        int highest = scores[0];
        int lowest = scores[0];

        for (int i = 1; i < n; i++) {
            if (scores[i] > highest) highest = scores[i];
            if (scores[i] < lowest) lowest = scores[i];
        }

        // Output results
        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        // Scores above average
        System.out.println("Scores above average:");
        boolean found = false;
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No scores above average.");
        }

        input.close();
    }
}

