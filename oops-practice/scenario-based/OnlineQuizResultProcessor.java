import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception 
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class OnlineQuizResultProcessor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Correct answers 
        String[] correctAnswers = {"A", "C", "B", "D", "A"};

        List<Integer> scoreList = new ArrayList<>();

        System.out.print("Enter number of users: ");
        int users = input.nextInt();
        input.nextLine(); 

        for (int u = 1; u <= users; u++) {
            System.out.println("\nUser " + u + " - Enter answers:");
            String[] userAnswers = new String[correctAnswers.length];

            for (int i = 0; i < correctAnswers.length; i++) {
                System.out.print("Q" + (i + 1) + ": ");
                userAnswers[i] = input.nextLine();
            }

            try {
                int score = calculateScore(correctAnswers, userAnswers);
                scoreList.add(score);

                String grade = getGrade(score, correctAnswers.length);

                System.out.println("Score: " + score + "/" + correctAnswers.length);
                System.out.println("Grade: " + grade);

            }
             catch (InvalidQuizSubmissionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Display all user scores
        System.out.println("\nAll User Scores:");
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.println("User " + (i + 1) + ": " + scoreList.get(i));
        }

        input.close();
    }
    // Compare answers and calculate score
    static int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                    "Answer count mismatch! Quiz submission is invalid.");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Return grade based on score
    static String getGrade(int score, int totalQuestions) {
        double percentage = (double) score / totalQuestions * 100;

        if (percentage >= 80) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "Fail";
    }
}

