package FunctionalInterfaces;
import java.util.Scanner;

interface UnitConverter {

    // convert kilometers to miles
    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // convert kilograms to pounds
    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}

public class UnitConversion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();
        System.out.println("Miles: " + UnitConverter.kmToMiles(km));

        System.out.print("Enter weight in kilograms: ");
        double kg = input.nextDouble();
        System.out.println("Pounds: " + UnitConverter.kgToPounds(kg));
        input.close();
    }
}
