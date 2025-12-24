//Write a program to find the distance in yards and miles for the distance provided by the user in feet

import java.util.Scanner;

class FeetToYardsMiles{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double distanceInFeet = input.nextDouble();   
        double yards = distanceInFeet / 3;            
        double miles = yards / 1760;                  
        System.out.println("The distance in yards is " + yards +" while the distance in miles is " + miles);
    }
}
