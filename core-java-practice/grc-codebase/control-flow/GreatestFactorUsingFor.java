//Create a program to print the greatest factor of a number beside itself using a for loop.

import java.util.Scanner;

public class GreatestFactorUsingFor{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");
        int number = input.nextInt();

        // Check for positive integer
        if(number <= 1){
            System.out.println("Please enter an integer greater than 1.");
        } 
		else{
            int greatestFactor = 1;
            for(int i = number - 1; i >= 1; i--){
                if(number % i == 0){
                    greatestFactor = i;
					// exit loop after finding greatest factor
                    break;   
                }
            }

            System.out.println("Greatest factor of "+ number +" besides itself is: "+ greatestFactor);
        }
        input.close();
    }
}
