//Write a program to take user input for 5 numbers and check whether a number is positive,  negative, or zero. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they equal, greater or less

import java.util.Scanner;

public class CheckNumber{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        // array of 5 integers
        int[] numbers = new int[5];

        // user input
        for(int i = 0; i < numbers.length; i++){
            System.out.print("Enter number "+(i + 1)+": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\nNumber Analysis:");

        // Loop through the array
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > 0){
                if(numbers[i] % 2 == 0){
                    System.out.println(numbers[i]+" is Positive and Even");
                } 
				else{
                    System.out.println(numbers[i]+" is Positive and Odd");
                }
            }
            else if(numbers[i] < 0){
                System.out.println(numbers[i]+" is Negative");
            }
            else{
                System.out.println(numbers[i]+" is Zero");
            }
        }

        // Compare first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        System.out.println("\nComparison of First and Last Elements:");
        if(first == last){
            System.out.println("First and Last elements are Equal");
        }
        else if(first > last){
            System.out.println("First element is Greater than Last element");
        }
        else{
            System.out.println("First element is Less than Last element");
        }
        input.close();
    }
}
