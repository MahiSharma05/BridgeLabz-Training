//Create a program to find the factors of a number taken as user input using while loop.

import java.util.Scanner;

public class FactorsUsingWhile{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer:");
        int number = input.nextInt();

        // Check for positive integer
        if(number <= 0){
            System.out.println("Please enter a valid positive integer.");
        } 
		else{
            System.out.println("Factors of "+ number+ " are:");
            int counter = 1;

            // Find factors 
            while(counter < number){
                if(number % counter == 0){
                    System.out.println(counter);
                }
                counter++;
            }
        }
        input.close();
    }
}
