package DsaProblems;
import java.util.Stack;

public class SortStackUsingRecursion {
	
	// Sort Stack
	public static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			sortStack(stack);
			insertSorted(stack , top);
		}
	}
	// insert element in sorted order
	public static void insertSorted(Stack<Integer> stack , int element) {
		if(stack.isEmpty() || stack.peek() <= element) {
			stack.push(element);
			return;
		}
		int top = stack.pop();
		insertSorted(stack , element);
		stack.push(top);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
	    stack.push(40);
	    stack.push(10);
	    stack.push(30);
	    stack.push(20);
	    
	    System.out.println("Original Stack " + stack);
	    
	    sortStack(stack);
	    
	    System.out.println("Stack After Sorting " + stack);

	}

}
