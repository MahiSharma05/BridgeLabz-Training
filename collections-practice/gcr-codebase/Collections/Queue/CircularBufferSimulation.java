package Queue;

public class CircularBufferSimulation {

    private int[] buffer;
    private int size;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public CircularBufferSimulation(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Insert element
    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;

        if (count == size) {
            // Buffer full → overwrite oldest
            front = (front + 1) % size;
        } else {
            count++;
        }
    }

    // Display buffer elements
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();   

        cb.insert(4);
        cb.display();   
    }
}

