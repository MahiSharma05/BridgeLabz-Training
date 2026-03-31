package practice;
import java.util.*;
public class KeyGeneration {
	
	public static void main(String[] args) {
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			if(input.isEmpty()) {
				System.out.println("invalid input (emppty string)");
			}
			else if(input.length() < 6) {
				System.out.println("Invalid input (length < 6)");
			}
			else if(input.contains(" ")) {
				System.out.println("Invalid input (contains space)");
			}
			else if(input.matches(".*\\d.*")) {
				System.out.println("Invalid input (contains digits)");
			}
			
			
			else if(!input.matches("[A-Za-z]+")) {
				System.out.println("Invalid input (contains special character)");
			}
			else {
				
			 input = input.toLowerCase();
			 
			StringBuilder str = new StringBuilder();
			for(char ch : input.toCharArray()) {
				if((int) ch % 2 != 0) {
					str.append(ch);
				}
			}
			if(str.length() == 0) {
				System.out.println("Invalid input (empty String)");
				continue;
			}
			str = str.reverse();

			char[] arr = str.toString().toCharArray();
			for(int i1 = 0; i1 < arr.length; i1++) {
				if(i1 % 2 == 0) {
					arr[i1] = Character.toUpperCase(arr[i1]);
				}
			}
			String key = new String(arr);
			System.out.println("The generated key is: " + key);
		}
		}
		sc.close();
	}

}
