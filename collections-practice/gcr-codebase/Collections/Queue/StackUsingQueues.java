package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Push operation
        public void push(int x) {
            // Add element to q2
            q2.add(x);

            // Move all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // Swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        // Pop operation
        public int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.remove();
        }

        // Top operation
        public int top() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.peek();
        }

        // Check empty
        public boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop element: " + stack.pop()); 
    }
}

