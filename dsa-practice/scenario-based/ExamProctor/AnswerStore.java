package ExamProctor;
import java.util.HashMap;

public class AnswerStore {
	private HashMap<Integer, String> studentAnswers = new HashMap<>();
	
	// Save answer
	public void submitAnswer(int questionId, String answer) {
		studentAnswers.put(questionId, answer);
		System.out.println("Answer saved for question " + questionId);
	}
    
	public HashMap<Integer, String> getStudentAnswers(){
		return studentAnswers;
	}
}
