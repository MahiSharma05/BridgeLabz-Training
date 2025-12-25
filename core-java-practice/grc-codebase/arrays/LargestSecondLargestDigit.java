//Create a program to store the digits of the number in an array and find the largest and second largest element of the array.

import java.util.Scanner;

public class LargestSecondLargestDigit{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        // Store digits in array
        while(number != 0){
            if(index == maxDigit){
                break; 
            }
            // last digit
            digits[index] = number % 10; 
             // remove last digit
            number = number / 10;         
            index++;
        }

        // Find largest and second largest
        int largest = 0;
        int secondLargest = 0;

        for(int i = 0; i < index; i++){
            if(digits[i] > largest){
                secondLargest = largest;
                largest = digits[i];
            } 
			else if(digits[i] > secondLargest && digits[i] != largest){
                secondLargest = digits[i];
            }
        }
        // show result
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        input.close();
    }
}
