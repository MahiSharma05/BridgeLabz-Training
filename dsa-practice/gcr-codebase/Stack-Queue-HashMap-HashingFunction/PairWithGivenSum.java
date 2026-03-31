package DsaProblems;
import java.util.HashSet;

class PairWithGivenSum {

    public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int required = target - num;

            if (set.contains(required)) {
                System.out.println("Pair found: " + num + " + " + required);
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 12;

        boolean result = hasPair(arr, target);
        System.out.println("Pair exists? " + result);
    }
}

