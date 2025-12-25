//Create a program to print a multiplication table of a number.

import java.util.Scanner;

public class MultiplicationTable{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // user input
        System.out.println("Enter an integer number:");
        int number = input.nextInt();

        // array to store multiplication results
        int[] table = new int[10];

        // Store multiplication table values in array
        for(int i = 1; i <= 10; i++){
            table[i - 1] = number * i;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table of "+number+ ":");
        for(int i = 1; i <= 10; i++){
            System.out.println(number+ " * " + i+ " = "+ table[i - 1]);
        }
        input.close();
    }
}
