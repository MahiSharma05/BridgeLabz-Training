// Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it

import java.util.Scanner;

public class FriendsComparison {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }

        // Find results
        String youngest = findYoungest(ages, names);
        String tallest = findTallest(heights, names);

        // Display results
        System.out.println("\nYoungest friend is: " + youngest);
        System.out.println("Tallest friend is: " + tallest);

        input.close();
    }
	
	// Method to find the youngest friend
    public static String findYoungest(int[] ages, String[] names) {

        int minAge = ages[0];
        String youngest = names[0];

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngest = names[i];
            }
        }
        return youngest;
    }

    // Method to find the tallest friend
    public static String findTallest(double[] heights, String[] names) {

        double maxHeight = heights[0];
        String tallest = names[0];

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallest = names[i];
            }
        }
        return tallest;
    }
}
