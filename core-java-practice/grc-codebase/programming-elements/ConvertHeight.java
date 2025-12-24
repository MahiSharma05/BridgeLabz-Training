//Write a program that takes your height in centimeters and converts it into feet and inches

import java.util.Scanner;

class ConvertHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double heightInCm = input.nextDouble();
        double totalInches = heightInCm / 2.54;
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;
        System.out.println(
                "Your Height in cm is " + heightInCm + " while in feet is " + feet + " and inches is " + inches);
    }
}
