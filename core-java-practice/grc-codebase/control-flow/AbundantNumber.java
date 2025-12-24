//Create a program to check if a number is an Abundant Number.

import java.util.Scanner;

public class AbundantNumber{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer:");
        int number = input.nextInt();

        if(number <= 0){
            System.out.println("Please enter a positive integer.");
        } 
		else{
            int sum = 0;

            // For loop to find sum of divisors
            for(int i = 1; i < number; i++){
                if(number % i == 0){
                    sum = sum + i;
                }
            }

            // Check Abundant Number
            if(sum > number){
                System.out.println(number + " is an Abundant Number");
            } 
			else{
                System.out.println(number + " is Not an Abundant Number");
            }
        }
        input.close();
    }
}
