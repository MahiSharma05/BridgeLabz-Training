//Write a program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number. Show all the numbers as well as the sum of all numbers

import java.util.Scanner;

public class StoreAndSum{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Declare array and variables
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Infinite while loop
        while(true){
            System.out.print("Enter a number 0 or negative to stop:");
            double number = input.nextDouble();

            // Break if input is 0 or negative
            if(number <= 0){
                break;
            }

            // Break if array limit reached
            if(index == 10){
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }

            // Store value in array and increment index
            numbers[index] = number;
            index++;
        }

        // Display stored numbers and calculate total
        System.out.println("\nStored Numbers:");
        for(int i = 0; i < index; i++){
            System.out.println(numbers[i]);
            total = total + numbers[i];
        }

        // Display total
        System.out.println("\nSum of all numbers = "+total);
        input.close();
    }
}
