package sorting;
import java.util.Arrays;

public class JobApplicantHeapSort {

    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        //Extract elements from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    private static void heapify(int[] salaries, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check leftChild
        if (left < heapSize && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check rightChild
        if (right < heapSize && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify affected subtree
            heapify(salaries, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaryDemands = {60000, 45000, 90000, 70000, 50000};

        System.out.println("Salary demands before sorting: "
                + Arrays.toString(salaryDemands));

        heapSort(salaryDemands);

        System.out.println("Salary demands after sorting: "
                + Arrays.toString(salaryDemands));
    }
}

