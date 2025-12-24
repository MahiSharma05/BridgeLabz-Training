//Write a program to calculate the volume of a cylinder. Take the radius and

import java.util.Scanner;

public class CylinderVolume{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double radius = input.nextDouble();

        System.out.print("Enter the height: ");
        double height = input.nextDouble();

        final double PI = 3.14;

        double volume = PI * radius * radius * height;

        System.out.println("Volume of the cylinder: " + volume);

        input.close();
    }
}
