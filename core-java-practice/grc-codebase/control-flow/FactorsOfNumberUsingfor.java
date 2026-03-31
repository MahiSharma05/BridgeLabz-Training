//Create a program to find the factors of a number taken as user input.

import java.util.Scanner;

public class FactorsOfNumberUsingfor{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");
        int number = input.nextInt();

        // Check for positive integer
        if(number <= 0){
            System.out.println("Please enter a valid positive integer.");
        } 
		else{
            System.out.println("Factors of "+ number+ " are:");
            for(int i = 1; i < number; i++) {
                if(number % i == 0){
                    System.out.println(i);
                }
            }
        }
        input.close();
    }
}
