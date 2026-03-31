//Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights

import java.util.Scanner;

public class FindYoungestAndTallest {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[] names = { "Amar", "Akbar", "Anthony" };
		int[] age = new int[3];
		double[] height = new double[3];

		for (int i = 0; i <= 2; i++) {
			System.out.println("Enter details for " + names[i]);
			System.out.println("Enter Age: ");
			age[i] = input.nextInt();

			System.out.println("Enter Height: ");
			height[i] = input.nextDouble();
		}

		// Assume Amar is youngest and tallest

		int youngestindex = 0;
		int tallestindex = 0;

		// find youngest and tallest
		for (int i = 1; i <= 2; i++) {
			if (age[i] < age[youngestindex]) {
				youngestindex = i;
			}
			if (height[i] < height[tallestindex]) {
				tallestindex = i;
			}
		}
		System.out.println("Youngest Friend: " + names[youngestindex] + " , Age: " + age[youngestindex]);
		System.out.println("Tallest Friend: " + names[tallestindex] + " , Height: " + height[tallestindex]);
		input.close();
	}
}