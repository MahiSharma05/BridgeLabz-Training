package List;
import java.util.ArrayList;
import java.util.List;

public class RotateListElements {

    // Rotate list left by k positions
    public static void rotateLeft(List<Integer> list, int k) {

        int n = list.size();
        if (n == 0) return;
        
        // handle k > n
        k = k % n; 

        reverse(list, 0, k - 1);
        reverse(list, k, n - 1);
        reverse(list, 0, n - 1);
    }

    // Helper method to reverse a portion of list
    private static void reverse(List<Integer> list, int left, int right) {

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        rotateLeft(list, 2);
        System.out.println(list);
    }
}

