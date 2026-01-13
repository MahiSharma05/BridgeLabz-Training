package ExaminationSystem;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Question question, String answer) {
        if (answer.length() >= 5) {
            return 1; 
        }
        return 0;
    }
}

