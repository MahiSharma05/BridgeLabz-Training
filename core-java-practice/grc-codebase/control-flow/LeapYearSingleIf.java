//Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year. determine Leap Year with single if condition using logical and && and or || operators 

import java.util.Scanner;

public class LeapYearSingleIf{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check Gregorian calendar and leap year using single if
        if(year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))){
            System.out.println(year + " is a Leap Year");
        } 
		else{
            System.out.println(year + " is NOT a Leap Year");
        }
        input.close();
    }
}
