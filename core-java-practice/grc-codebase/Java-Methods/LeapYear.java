// Write a program that takes a year as input and outputs the Year is a Leap Year or not 

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take year input
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check Gregorian calendar condition
        if (year < 1582) {
            System.out.println("Leap year calculation is valid only for year >= 1582.");
        } else {

            // Call method to check leap year
            boolean isLeap = isLeapYear(year);

            if (isLeap) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        }

        input.close();
    }

    // Method to check Leap Year
    public static boolean isLeapYear(int year) {

        // Condition a and b
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
