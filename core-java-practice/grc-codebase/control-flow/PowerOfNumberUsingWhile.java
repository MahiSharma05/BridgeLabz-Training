//Create a program to find the power of a number using while loop.

import java.util.Scanner;

public class PowerOfNumberUsingWhile{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the power: ");
        int power = input.nextInt();

        // Check for valid input
        if(number <= 0 || power < 0){
            System.out.println("Please enter valid positive integers.");
        }
		else{
            int result = 1;
            int counter = 0;
            while(counter < power){
                result = result * number;
                counter++;
            }
            // show result
            System.out.println(number+ " raised to the power " + power +" is: "+ result);
        }
        input.close();
    }
}

