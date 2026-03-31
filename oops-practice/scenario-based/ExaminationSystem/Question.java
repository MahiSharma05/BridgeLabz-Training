package ExaminationSystem;

public class Question {

    private int questionId;
    private String questionText;
    private String correctAnswer;
    private boolean objective;

    public Question(int questionId, String questionText, String correctAnswer, boolean objective) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.objective = objective;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isObjective() {
        return objective;
    }
}

