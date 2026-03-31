package DsaProblems;
import java.util.Stack;

public class QueueUsingStacks {

	Stack<Integer> inStack = new Stack<>();
	Stack<Integer> outStack = new Stack<>();

	// Enqueue 
	public void enqueue(int data) {
		inStack.push(data);
		System.out.println(data + " enqueued ");
	}
	
	// dequeue
	public int dequeue() {
		if(inStack.isEmpty() && outStack.isEmpty()) {
				throw new RuntimeException("Queue is Empty");
			}
			// transfer elements
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}
	
	
	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}
	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		
		System.out.println(queue.dequeue() + " dequeued");
		System.out.println(queue.dequeue() + " dequeued");
		
		queue.enqueue(90);
		
		System.out.println(queue.dequeue() +" dequeued");
		System.out.println(queue.dequeue() + " dequeued");

	}

}
