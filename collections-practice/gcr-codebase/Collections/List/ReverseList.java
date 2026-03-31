package List;
import java.util.ArrayList;
import java.util.List;

public class ReverseList {

    public static void reverseArrayList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Before Reverse: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("After Reverse : " + arrayList);
    }
}

