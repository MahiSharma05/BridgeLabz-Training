//Create a program to check if a number taken from the user is a Harshad Number.

import java.util.Scanner;

public class HarshadNumber{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer number:");
        int number = input.nextInt();
        int originalNumber = number; 
        int sum = 0;

        // While loop to find sum of digits
        while(number != 0){
            int digit = number % 10;   
            sum = sum + digit;         
            number = number / 10;      
        }

        // Check Harshad Number
        if(originalNumber % sum == 0){
            System.out.println(originalNumber +" is a Harshad Number");
        } 
		else{
            System.out.println(originalNumber +" is Not a Harshad Number");
        }
        input.close();
    }
}
