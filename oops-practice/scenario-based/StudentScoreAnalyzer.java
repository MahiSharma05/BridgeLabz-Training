import java.util.Scanner;

public class StudentScoreAnalyzer {

    // Custom Exception
    static class InvalidScoreException extends Exception {
        public InvalidScoreException(String message) {
            super(message);
        }
    }

    // Method to calculate average score
    public static double calculateAverage(int[] scores) throws InvalidScoreException {
        validateScores(scores);

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // Method to find highest score
    public static int findMax(int[] scores) throws InvalidScoreException {
        validateScores(scores);

        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // Method to find lowest score
    public static int findMin(int[] scores) throws InvalidScoreException {
        validateScores(scores);

        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    // Common validation method
    private static void validateScores(int[] scores) throws InvalidScoreException {
        if (scores == null || scores.length == 0) {
            throw new InvalidScoreException("Score array is empty");
        }

        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException(
                        "Invalid score found: " + score + " (Scores must be between 0 and 100)");
            }
        }
    }

    // Main method (User Input)
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter student scores (0–100):");
        for (int i = 0; i < n; i++) {
            scores[i] = input.nextInt();
        }

        try {
            double average = calculateAverage(scores);
            int highest = findMax(scores);
            int lowest = findMin(scores);

            System.out.println("\nStudent Scores Analysis:");
            System.out.println("Average Score : " + average);
            System.out.println("Highest Score : " + highest);
            System.out.println("Lowest Score  : " + lowest);

        } catch (InvalidScoreException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        input.close();
    }
}
