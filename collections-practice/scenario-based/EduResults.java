package scenariio;

import java.util.Scanner;

public class EduResults {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Stable merge
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {   
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of districts: ");
        int districts = input.nextInt();

        int totalStudents = 0;
        int[][] districtMarks = new int[districts][];

        // Input district-wise sorted marks
        for (int i = 0; i < districts; i++) {
            System.out.print("Enter number of students in district " + (i + 1) + ": ");
            int size = input.nextInt();
            districtMarks[i] = new int[size];
            totalStudents += size;

            System.out.println("Enter sorted marks:");
            for (int j = 0; j < size; j++) {
                districtMarks[i][j] = input.nextInt();
            }
        }

        // merge all district lists into one array
        int[] allMarks = new int[totalStudents];
        int index = 0;

        for (int[] district : districtMarks) {
            for (int mark : district) {
                allMarks[index++] = mark;
            }
        }

        // apply Merge Sort
        mergeSort(allMarks, 0, allMarks.length - 1);

        // Final rank list
        System.out.println("\nState-wise Rank List:");
        for (int i = 0; i < allMarks.length; i++) {
            System.out.println("Rank " + (i + 1) + ": " + allMarks[i]);
        }

        input.close();
    }
}

