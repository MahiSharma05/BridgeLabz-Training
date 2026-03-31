//Write a program to calculate the perimeter of a rectangle. Take the length and width as inputs

import java.util.Scanner;

public class RectanglePerimeter{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length: ");
        double length = input.nextDouble();

        System.out.print("Enter the width: ");
        double width = input.nextDouble();

        double perimeter = 2 * (length + width);

        System.out.println("Perimeter of the rectangle: " + perimeter);

        input.close();
    }
}
