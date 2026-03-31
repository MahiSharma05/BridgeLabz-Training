// An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete

import java.util.Scanner;

public class TotalAthleteRounds {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // input
        System.out.print("Enter side 1 in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 in meters: ");
        double side3 = input.nextDouble();

        // Calculate rounds
        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("The athlete must complete " + rounds + " rounds to run 5 km.");
        input.close();
    }
        // Method calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {

        // Perimeter 
        double perimeter = side1 + side2 + side3;

        // 5 km = 5000 meters
        double totalDistance = 5000;

        // Total rounds
        return totalDistance / perimeter;
    }

}
