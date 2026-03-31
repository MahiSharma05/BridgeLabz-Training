//Create a program to take a number as input and reverse the number. To do this, store the digits of the number in an array and display the array in reverse order

import java.util.Scanner;

public class ReverseNumberByArray{
    public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
		System.out.println("Enter number: ");
		int number = input.nextInt();
		int temp = number;
		int count = 0;
		
		// find number of digits
		while(temp != 0){
		    count++;
			temp = temp / 10;
		}
		
		// store digits in array
		
		int[] digits = new int[count];
		int index = 0;
		
		while(number != 0){
		    digits[index] = number%10;
			number = number / 10;
			index++;
		}

        // revrese the digits array

        int[] reverse = new int[count];
        for(int i = 0; i < count; i++){
		    reverse[i] = digits[count - 1 -i];
		}

        // display reversed number
        System.out.println("Reversed number: ");
        for(int i = 0; i < count; i++){
            System.out.println(reverse[i]);
        }

        input.close();
    }
}	
		