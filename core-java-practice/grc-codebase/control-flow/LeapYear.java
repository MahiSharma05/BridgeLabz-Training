//Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year. 

import java.util.Scanner;

public class LeapYear{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check for Gregorian calendar
        if(year < 1582){
            System.out.println("Year should be 1582 or later (Gregorian calendar).");
        } 
        else{
          // PART 1: Using multiple if-else statements
            System.out.println("Using multiple if-else:");
            if(year % 400 == 0){
                System.out.println(year + " is a Leap Year");
            } 
            else if(year % 100 == 0){
                System.out.println(year + " is NOT a Leap Year");
            } 
            else if(year % 4 == 0){
                System.out.println(year + " is a Leap Year");
            } 
            else{
                System.out.println(year + " is NOT a Leap Year");
            }

            // PART 2: Using single if statement with logical operators
            System.out.println("\nUsing single if statement:");
            if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                System.out.println(year + " is a Leap Year");
            } 
            else{
                System.out.println(year + " is NOT a Leap Year");
            }
        }
        input.close();
    }
}
