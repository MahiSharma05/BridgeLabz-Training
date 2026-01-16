package sorting;
import java.util.Arrays;

public class ProductPrices {
	
	// Sort prices 
	 public static void sortPrices(int[] prices, int low, int high) {
	        if (low < high) {
	            int pi = partition(prices, low, high);
	            sortPrices(prices, low, pi - 1);
	            sortPrices(prices, pi + 1, high);
	        }
	    }
	 private static int partition(int[] prices, int low, int high) {
	        int pivot = prices[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (prices[j] < pivot) {
	                i++;
	                int temp = prices[i];
	                prices[i] = prices[j];
	                prices[j] = temp;
	            }
	        }
	        int temp = prices[i + 1];
	        prices[i + 1] = prices[high];
	        prices[high] = temp;
	        return i + 1;
	    }
	 public static void main(String[] args) {
	        int[] prices = {50, 30, 800, 45, 200};
	        sortPrices(prices, 0, prices.length - 1);
	        System.out.println(Arrays.toString(prices));
	    }
}
