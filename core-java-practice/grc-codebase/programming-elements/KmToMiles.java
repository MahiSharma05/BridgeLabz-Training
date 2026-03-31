//Create a program to convert distance in kilometers to miles.

import java.util.Scanner;

class KmToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double kilometer = input.nextInt();
        double miles = kilometer / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + kilometer + " km");
    }
}