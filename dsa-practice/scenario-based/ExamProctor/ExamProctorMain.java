package ExamProctor;
import java.util.Scanner;

public class ExamProctorMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExamNavigator navigator = new ExamNavigator();
		AnswerStore answerStore = new AnswerStore();
        ScoreEvaluator evaluator = new ScoreEvaluator();
        
        int choice;
        do {
        	System.out.println("----Exam Proctor----");
        	System.out.println("1. Visit Question");
        	System.out.println("2. Go Back");
        	System.out.println("3. Submit Answer");
        	System.out.println("4. Submit Exam and calculate score");
        	System.out.println("5. Exit");
        	System.out.println("Enter choice");
        	
            choice = input.nextInt();

            switch(choice) {
            case 1: 
            	System.out.println("Enter Question Id: ");
                int qId = input.nextInt();
                navigator.visitQuestion(qId);
                break;
            case 2:
            	navigator.goBack();
                break;
            case 3:
            	System.out.println("Enter Question Id: ");
                int q = input.nextInt();
            	System.out.println("Enter Answer (A/B/C/D): ");
            	String ans = input.next();
            	answerStore.submitAnswer(q, ans);
            	break;
            case 4:
            	int score = evaluator.calculateScore(answerStore.getStudentAnswers());
            	System.out.println("Final score: " + score);
            	break;
            case 5:
            	System.out.println("Exiting");
            	break;
            default: 
            	System.out.println("Invalid choice");
            }
        }
        while(choice != 5);
        
        input.close();

	}

}
