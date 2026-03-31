package ExaminationSystem;

public class Exam {

    private String examName;
    private Question[] questions;
    private int questionCount;
    private long startTime;
    private long duration; // milliseconds

    public Exam(String examName, int maxQuestions, long duration) {
        this.examName = examName;
        this.questions = new Question[maxQuestions];
        this.questionCount = 0;
        this.duration = duration;
    }

    public void addQuestion(Question question) {
        questions[questionCount++] = question;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void startExam() {
        startTime = System.currentTimeMillis();
    }

    public boolean isTimeOver() {
        return System.currentTimeMillis() - startTime > duration;
    }

    public String getExamName() {
        return examName;
    }
}

