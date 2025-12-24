//Write a program that takes three numbers as input from the user and prints their average.

import java.util.Scanner;

public class AverageOfThreeNumber{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        System.out.print("Enter third number: ");
        double number3 = input.nextDouble();

        double average = (number1 + number2 + number3) / 3;

        System.out.println("Average = "+ average);
        input.close();
    }
}
