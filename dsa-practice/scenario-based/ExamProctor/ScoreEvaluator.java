package ExamProctor;
import java.util.HashMap;

public class ScoreEvaluator {
	private HashMap<Integer, String> correctAnswers = new HashMap<>();
	
	// Initialize correct answers
	public ScoreEvaluator() {
		correctAnswers.put(1, "A");
		correctAnswers.put(2, "B");
		correctAnswers.put(3, "C");
		correctAnswers.put(4, "D");
	}
	
	// Calculate scores
    public int calculateScore(HashMap<Integer, String> studentAnswers) {
    	int score = 0;
    	for(int questionId : correctAnswers.keySet()) {
    		if(studentAnswers.containsKey(questionId) && studentAnswers.get(questionId).equals(correctAnswers.get(questionId))) {
    			score++;
    		}
    	}
    	return score;
    }
}
