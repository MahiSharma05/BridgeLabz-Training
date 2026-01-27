package ExceptionHandling;
import java.util.*;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			int arr[] = {4,6,9,2,5};
			System.out.println("Enter index:");
			int index = input.nextInt();
			System.out.println("Value at index " + index + " : " + arr[index]);
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index!");
		}
		catch(NullPointerException e) {
			System.out.println("Array is not initialized!");
		}
		finally {
			input.close();
		}
	}

}
