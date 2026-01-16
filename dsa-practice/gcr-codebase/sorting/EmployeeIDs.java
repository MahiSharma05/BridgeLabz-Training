package sorting;

import java.util.Arrays;

public class EmployeeIDs {
	
	public static void sortIDs(int[] ids) {
		int n = ids.length;
		for(int i = 1; i < n; i++) {
			int key = ids[i];
			int j = i - 1;
			
			// Move IDs that are greater than key to one position ahead
            while(j >= 0 && ids[j] > key) {
            	ids[j + 1] = ids[j];
            	j--;
            }
            ids[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] ids= {3, 5, 1, 4, 2};
		System.out.println("IDs before sorting " + Arrays.toString(ids));
		sortIDs(ids);
		System.out.println("IDs after sorting " + Arrays.toString(ids));

	}

}
