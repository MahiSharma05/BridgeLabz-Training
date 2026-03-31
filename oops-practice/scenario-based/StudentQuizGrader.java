package scenario;

public class StudentQuizGrader {

    // calculate score and print feedback
    static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        System.out.println("Quiz Feedback:");

        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                score++;
                System.out.println("Question " + (i + 1) + ": Correct");
            } 
            else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }

    public static void main(String[] args) {

        // Correct answers
        String[] correctAnswers = {"A", "B", "C", "D", "A", "C", "B", "D", "A", "C"
        };

        // Student answers
        String[] studentAnswers = {"a", "b", "c", "a", "A","c", "b", "d", "b", "c"};

        // score
        int score = calculateScore(correctAnswers, studentAnswers);

        // percentage
        double percentage = (score / 10.0) * 100;

        System.out.println("\nTotal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        // Pass / Fail
        if (percentage >= 50) {
            System.out.println("Result: PASS ");
        } else {
            System.out.println("Result: FAIL ");
        }
    }
}

