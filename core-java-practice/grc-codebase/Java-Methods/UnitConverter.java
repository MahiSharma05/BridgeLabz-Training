// Extend or Create a UnitConvertor utility class similar to the one shown in the notes to do the following.  Please define static methods for all the UnitConvertor class methods.

public class UnitConverter {

    public static void main(String[] args) {

        System.out.println("10 km in miles = " + UnitConverter.convertKmToMiles(10));
        System.out.println("5 miles in km = " + UnitConverter.convertMilesToKm(5));
        System.out.println("3 meters in feet = " + UnitConverter.convertMetersToFeet(3));
        System.out.println("10 feet in meters = " + UnitConverter.convertFeetToMeters(10));
    }

    // Convert Kilometers to Miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Convert Miles to Kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Convert Meters to Feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Convert Feet to Meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
}
