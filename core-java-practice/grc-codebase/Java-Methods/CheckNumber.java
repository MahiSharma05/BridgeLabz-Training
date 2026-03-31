// Write a program to check whether a number is positive, negative, or zero.


import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // take input
        System.out.print("Enter Number: ");
        int number = input.nextInt();

        int result = numberIs(number);

        if (result == 1){
            System.out.println("The number is Positive.");
        } 
		else if (result == -1) {
            System.out.println("The number is Negative.");
        } 
		else {
            System.out.println("The number is Zero.");
        }
        input.close();
    }
	
	    // Method to check number
    public static int numberIs(int num){
        if (num > 0) {
            return 1;      
        } 
		else if (num < 0) {
            return -1;    
        } 
		else {
            return 0;      
        }
    }
}
