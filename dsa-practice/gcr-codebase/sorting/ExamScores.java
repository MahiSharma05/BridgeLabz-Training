package sorting;
import java.util.Arrays;

public class ExamScores {

    public static void sortScores(int[] scores) {

        int n = scores.length;

        // Loop for each position in the array
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find minimum element in remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap if minimum is not at correct position
            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] examScores = {78, 45, 89, 62, 95, 50};

        System.out.println("Exam scores before sorting: "
                + Arrays.toString(examScores));

        sortScores(examScores);

        System.out.println("Exam scores after sorting: "
                + Arrays.toString(examScores));
    }
}

