package Array;

public class ArrayDuplication {

    public static void main(String[] args) {

        int[] numbers = {5,6,5,7,8,4,5,2,1};

        int[] uniqueArray = removeDuplicate(numbers);

        for (int num : uniqueArray) {
            System.out.print(num + " ");
        }
    }
	public static int[] removeDuplicate(int[] arr) {

        int[] temp = new int[arr.length];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int k = 0; k < j; k++) {
                if (arr[i] == temp[k]) {
                    isDuplicate = true;
                    break;
                }
            }
           
            if (!isDuplicate) {
                temp[j++] = arr[i];
            }
        }
        
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}

