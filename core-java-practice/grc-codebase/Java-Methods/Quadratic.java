// Write a program Quadratic to find the roots of the equation ax2+ bx + c. Use Math functions Math.pow() and Math.sqrt()

import java.util.Scanner;

public class Quadratic {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter value of a: ");
        double a = input.nextDouble();

        System.out.print("Enter value of b: ");
        double b = input.nextDouble();

        System.out.print("Enter value of c: ");
        double c = input.nextDouble();

        // Call method
        double[] roots = findRoots(a, b, c);

        // Display result
        if (roots.length == 0) {
            System.out.println("No real roots (Delta is negative)");
        } else if (roots.length == 1) {
            System.out.println("Only one root: " + roots[0]);
        } else {
            System.out.println("Two roots are:");
            System.out.println("Root 1 = " + roots[0]);
            System.out.println("Root 2 = " + roots[1]);
        }

        input.close();
    }
	
	// Method to find roots of quadratic equation
    public static double[] findRoots(double a, double b, double c) {

        double delta = Math.pow(b, 2) - (4 * a * c);

        // If delta is negative → no real roots
        if (delta < 0) {
            return new double[0];   // empty array
        }

        // If delta is zero → one root
        if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }

        // If delta is positive → two roots
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);

        return new double[]{root1, root2};
    }
}
