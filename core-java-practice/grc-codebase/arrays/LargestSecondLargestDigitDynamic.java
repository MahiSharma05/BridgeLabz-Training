//Create a program to store the digits of the number in an array and find the largest and second largest element of the array.Here we want to modify to Increase the size of the array i,e maxDigit by 10 if the index is equal to maxDigit. This is done to consider all digits to find the largest and second-largest numbe

import java.util.Scanner;

public class LargestSecondLargestDigitDynamic{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        // number input
        System.out.println("Enter a number: ");
        int number = input.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store digits with dynamic resizing
        while(number != 0){
            // If array is full, increase size by 10
            if(index == maxDigit){
                maxDigit = maxDigit + 10;

                int[] temp = new int[maxDigit];

                // Copy old digits to new array
                for(int i = 0; i < digits.length; i++){
                    temp[i] = digits[i];
                }
				// assign new array
                digits = temp; 
            }
			// extract digit
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
        // display result
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        input.close();
    }
}

