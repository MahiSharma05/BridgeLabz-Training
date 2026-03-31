//Write a program that takes the distance in kilometers as input from the user and converts it into miles 

import java.util.Scanner;

public class KilometersToMiles{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();

        double miles = km * 0.621371;

        System.out.println("Distance in miles: " + miles);
        input.close();
    }
}
