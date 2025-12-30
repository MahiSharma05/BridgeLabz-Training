// Write a program to find the 3 points that are collinear using the slope formulae and area of triangle formulae. check  A (2, 4), B (4, 6) and C (6, 8) are Collinear for sampling.

import java.util.Scanner;

public class CollinearPoints {

    // Method to check collinearity using slope formula
    public static boolean checkBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {

        // To avoid division by zero, compare cross multiplication
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    // Method to check collinearity using area of triangle
    public static boolean checkByArea(int x1, int y1, int x2, int y2, int x3, int y3) {

        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        return area == 0;
    }

    // Main method
    public static void main(String[] args) {

        // Scanner object for input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        int x1 = input.nextInt();
        int y1 = input.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = input.nextInt();
        int y2 = input.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = input.nextInt();
        int y3 = input.nextInt();

        // Check using slope method
        if (checkBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear (Slope Method)");
        } else {
            System.out.println("Points are NOT collinear (Slope Method)");
        }

        // Check using area method
        if (checkByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear (Area Method)");
        } else {
            System.out.println("Points are NOT collinear (Area Method)");
        }

        input.close();
    }
}
