//Write a program that takes the base and height in cm to find the area of a triangle in square inches and square centimeters 

import java.util.Scanner;

class AreaOfTriangle{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();    
        double height = input.nextDouble();   
        double areaCm = 0.5 * base * height;
               // Convert sq cm to sq inches , 1 inch = 2.54 cm
        double areaInches = areaCm /(2.54 * 2.54);
        System.out.println("The Area of the triangle in sq in is " + areaInches +" and sq cm is " + areaCm);
    }
}
