package ExamProctor;
import java.util.Stack;

public class ExamNavigator {
	private Stack<Integer> navigationStack = new Stack<>();
	
	// Visiting Question
	public void visitQuestion(int questionId) {
		navigationStack.push(questionId);
		System.out.println(" Visited Question: " + questionId);
	}
	
	// Go back to last Visited Question
	public void goBack() {
		if(!navigationStack.isEmpty()) {
			int last = navigationStack.pop();
			System.out.println("Back from question: "  + last);
		}
		else {
			System.out.println("No Previous question");
		}
	}

}
