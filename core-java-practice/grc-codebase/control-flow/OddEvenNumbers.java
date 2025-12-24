//Create a program to print odd and even numbers between 1 to the number entered by the user.

import java.util.Scanner;

public class OddEvenNumbers{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check for natural number
        if (number <= 0){
            System.out.println("Please enter a valid natural number.");
        } 
		else{
            for (int i = 1; i <= number; i++) {
                // Check odd or even
                if(i % 2 == 0){
                    System.out.println(i + " is an Even number");
                } 
				else{
                    System.out.println(i + " is an Odd number");
                }
            }
        }

        input.close();
    }
}
