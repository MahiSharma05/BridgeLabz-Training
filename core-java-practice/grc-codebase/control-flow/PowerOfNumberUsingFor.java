//Create a program to find the power of a number using for loop.

import java.util.Scanner;

public class PowerOfNumberUsingFor{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer , number: ");
        int number = input.nextInt();

        System.out.println("Enter a positive integer , power: ");
        int power = input.nextInt();

        // Check for positive integers
        if(number <= 0 || power < 0){
            System.out.println("Please enter valid positive integers.");
        } 
		else{
            int result = 1;
            for (int i = 1; i <= power; i++){
                result = result * number;
            }

            // show result
            System.out.println(number+ " raised to the power "+ power +" is: " + result);
        }
        input.close();
    }
}
