package trafficmanager;

public class VehicleQueue {

    private String[] queue;
    private int front, rear, size;

    public VehicleQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void add(String vehicle) {

        if (size == queue.length) {
            System.out.println("Queue Overflow! Cannot add vehicle.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = vehicle;
        size++;
        System.out.println("Vehicle added to waiting queue: " + vehicle);
    }

    // Dequeue
    public String remove() {

        if (size == 0) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return null;
        }

        String vehicle = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return vehicle;
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }
}
