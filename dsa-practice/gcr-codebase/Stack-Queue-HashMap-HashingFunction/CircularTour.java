package DsaProblems;
import java.util.Queue;
import java.util.LinkedList;

class CircularTour {

    public static int findStart(int[] petrol, int[] distance) {
        int n = petrol.length;

        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0;
        int i = 0;

        while (i < 2 * n) { 

            int idx = i % n;
            queue.offer(idx);
            surplus += petrol[idx] - distance[idx];

            // If surplus is negative, remove from front
            while (!queue.isEmpty() && surplus < 0) {
                int removed = queue.poll();
                surplus -= petrol[removed] - distance[removed];
            }

            // If all pumps are in queue
            if (queue.size() == n) {
                return queue.peek();
            }

            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStart(petrol, distance);

        System.out.println("Starting Pump Index: " + start);
    }
}

