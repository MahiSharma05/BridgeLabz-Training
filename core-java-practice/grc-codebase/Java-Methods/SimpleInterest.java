// Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.

import java.util.Scanner;

public class SimpleInterest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double principal = input.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter Time: ");
        double time = input.nextDouble();

        // Calculate Simple Interest
        double simpleInterest = calculateSI(principal, rate, time);

        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal +", Rate of Interest " + rate + " and Time " + time);

        input.close();
    }

        // Method for Simple Interest
    public static double calculateSI(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

}
