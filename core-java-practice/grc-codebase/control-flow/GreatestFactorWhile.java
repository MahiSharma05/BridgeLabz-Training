//Create a program to print the greatest factor of a number beside itself using a while loop.

import java.util.Scanner;

public class GreatestFactorWhile{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter an integer greater than 1:");
        int number = input.nextInt();

        // Check for valid input
        if(number <= 1){
            System.out.println("Please enter a valid integer greater than 1.");
        }
		else{
            int greatestFactor = 1;
            int counter = number - 1;
            while (counter >= 1){
                if(number % counter == 0){
                    greatestFactor = counter;
					// stop loop after finding the greatest factor
                    break;   
                }
                counter--;
            }
            // show result
            System.out.println("Greatest factor of "+ number +" besides itself is: "+ greatestFactor);
        }
        input.close();
    }
}
