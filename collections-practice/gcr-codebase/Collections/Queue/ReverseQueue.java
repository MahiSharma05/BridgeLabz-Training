package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
	
	public static void reverseQueue(Queue<Integer> numbers) {
		
		// Base condition
		if(numbers.isEmpty()) {
			return;
		}
		
		// Remove front element
		int front = numbers.remove();
		
		// Reverse remaining queue
		reverseQueue(numbers);
		
		// Add removed element at rear
		numbers.add(front);
	}

	public static void main(String[] args) {
		Queue<Integer> numbers = new LinkedList<>();
		
		// Add elements in Queue
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		
        System.out.println(" Queue: " + numbers);
        
        reverseQueue(numbers);
        
        System.out.println(" Reverse Queue: " + numbers);



	}

}
