package Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class GenerateBinaryNumbers {
	
	public static List<String> generateBinaryNumber(int n) {
		List<String> result = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		
		queue.add("1");
		
		for(int i = 0; i < n; i++ ) {
			String current = queue.remove();
			
			result.add(current);
			
			queue.add(current + "0");
			queue.add(current + "1");
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Integer Value: ");
		int n = input.nextInt(); 
		System.out.println(generateBinaryNumber(n));
		
		input.close();

	}

}
