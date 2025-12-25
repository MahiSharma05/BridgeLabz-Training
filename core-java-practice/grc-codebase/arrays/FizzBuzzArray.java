//Write a program FizzBuzz, take a number as user input and if it is a positive integer loop from 0 to the number and save the number, but for multiples of 3 save "Fizz" instead of the number, for multiples of 5 save "Buzz", and for multiples of both save "FizzBuzz". Finally, print the array results for each index position in the format Position 1 = 1, …, Position 3 = Fizz,...

import java.util.Scanner;

public class FizzBuzzArray{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer:");
        int number = input.nextInt();

        // Check for positive integer
        if(number <= 0){
            System.out.println("Please enter a positive integer");
            input.close();
            return;
        }

        // Create String array to store results 0 to number
        String[] results = new String[number + 1];

        // Store FizzBuzz results in array
        for(int i = 0; i <= number; i++){
            if(i % 3 == 0 && i % 5 == 0 && i != 0){
                results[i] = "FizzBuzz";
            } 
            else if(i % 3 == 0 && i != 0){
                results[i] = "Fizz";
            } 
            else if(i % 5 == 0 && i != 0){
                results[i] = "Buzz";
            } 
            else{
                results[i] = String.valueOf(i);
            }
        }

        // Display array results with position
        System.out.println("\nFizzBuzz Results:");
        for(int i = 0; i <= number; i++){
            System.out.println("Position "+i+" = "+results[i]);
        }
        input.close();
    }
}
