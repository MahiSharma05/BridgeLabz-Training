//Create a program to find all the multiples of a number taken as user input below 100.

import java.util.Scanner;

public class MultiplesBelowHundred{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer less than 100:");
        int number = input.nextInt();

        // Check valid input
        if(number <= 0 || number >= 100){
            System.out.println("Please enter a positive integer less than 100.");
        }
		else{
            System.out.println("Multiples of " + number + " below 100 are:");

            // backward Loop from 100 to 1
            for(int i = 100; i >= 1; i--){
                if(i % number == 0){
                    System.out.println(i);
                }
            }
        }
        input.close();
    }
}
