package practice2;

import java.util.Scanner;

public class HybridNetworkIdentifiers {

	public static String validate(String input) {
		if(!input.matches("^(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4})::(([0-9A-F]{2}:){5}[0-9A-F]{2})$")) {
			return "unauthenticates device";
		}
		return "Authenticated device";
	}
	public static void main(String[] args) {

		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine().trim();
			System.out.println(validate(input));
		}
	}

}
