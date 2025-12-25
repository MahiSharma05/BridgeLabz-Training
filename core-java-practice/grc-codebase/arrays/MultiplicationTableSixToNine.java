//Create a program to find the multiplication table of a number entered by the user from 6 to 9 and display the result

import java.util.Scanner;

public class MultiplicationTableSixToNine{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter an integer number:");
        int number = input.nextInt();

        // Array to store multiplication results 6 to 9 → 4 values
        int[] multiplicationResult = new int[4];

        // Store multiplication table from 6 to 9
        int index = 0;
        for(int i = 6; i <= 9; i++){
            multiplicationResult[index] = number * i;
            index++;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table of "+ number+ " from 6 to 9:");
        index = 0;
        for(int i = 6; i <= 9; i++){
            System.out.println(number+ " * "+ i+ " = "+ multiplicationResult[index]);
            index++;
        }
        input.close();
    }
}
