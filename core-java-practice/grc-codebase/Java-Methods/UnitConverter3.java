// UnitConvertor Temperature, Weight & Volume

public class UnitConverter3 {

    public static void main(String[] args) {

        System.out.println("98.6 F in Celsius = " +
                UnitConverter3.convertFarhenheitToCelsius(98.6));

        System.out.println("37 C in Fahrenheit = " +
                UnitConverter3.convertCelsiusToFarhenheit(37));

        System.out.println("150 pounds in kilograms = " +
                UnitConverter3.convertPoundsToKilograms(150));

        System.out.println("70 kg in pounds = " +
                UnitConverter3.convertKilogramsToPounds(70));

        System.out.println("5 gallons in liters = " +
                UnitConverter3.convertGallonsToLiters(5));

        System.out.println("10 liters in gallons = " +
                UnitConverter3.convertLitersToGallons(10));
    }

    // Convert Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }

    // Convert Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }

    // Convert Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Convert Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Convert Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Convert Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
}
 

