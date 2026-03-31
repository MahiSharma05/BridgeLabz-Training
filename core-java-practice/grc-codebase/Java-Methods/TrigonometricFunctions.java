// Write a program to calculate various trigonometric functions using Math class given an angle in degrees

import java.util.Scanner;

public class TrigonometricFunctions {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // take input
        System.out.print("Enter angle in degrees: ");
        double angle = input.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println("Sine value: " + result[0]);
        System.out.println("Cosine value: " + result[1]);
        System.out.println("Tangent value: " + result[2]);
        input.close();
    }
	
	// Method to calculate sine, cosine, and tangent
    public static double[] calculateTrigonometricFunctions(double angle) {

        // Convert degrees to radians
        double radians = Math.toRadians(angle);

        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }
}
