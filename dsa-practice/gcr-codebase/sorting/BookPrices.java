package sorting;
import java.util.Arrays;

public class BookPrices {

    public static void sortPrices(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left half
            sortPrices(prices, left, mid);

            // Sort right half
            sortPrices(prices, mid + 1, right);

            // Merge both halves
            merge(prices, left, mid, right);
        }
    }

    private static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(prices, left, leftArr, 0, n1);
        System.arraycopy(prices, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                prices[k++] = leftArr[i++];
            } else {
                prices[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            prices[k++] = leftArr[i++];
        }

        while (j < n2) {
            prices[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] prices = {50, 100, 80, 150, 77};

        System.out.println("Book prices before sorting: " + Arrays.toString(prices));

        sortPrices(prices, 0, prices.length - 1);

        System.out.println("Book prices after sorting: " + Arrays.toString(prices));
    }
}
