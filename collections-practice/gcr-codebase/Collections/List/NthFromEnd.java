package List;

import java.util.LinkedList;
import java.util.Iterator;

public class NthFromEnd {

    public static String findNthFromEnd(LinkedList<String> list, int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is greater than list size");
            }
            fast.next();
        }

        // Move both until fast reaches end
        String result = null;
        while (fast.hasNext()) {
            fast.next();
            result = slow.next();
        }

        // When fast reaches end, slow is at Nth from end
        if (result == null) {
            result = slow.next();
        }

        return result;
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        System.out.println("Nth element from end: " + findNthFromEnd(list, n));
    }
}

