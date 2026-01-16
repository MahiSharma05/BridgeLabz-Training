package sorting;
import java.util.Arrays;

public class StudentAgeCountingSort {

    public static void countingSort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        //Count frequency of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        //Cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in correct position (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {

        int[] studentAges = {12, 15, 10, 18, 14, 12, 16, 10};

        System.out.println("Student ages before sorting: "
                + Arrays.toString(studentAges));

        countingSort(studentAges);

        System.out.println("Student ages after sorting: "
                + Arrays.toString(studentAges));
    }
}

