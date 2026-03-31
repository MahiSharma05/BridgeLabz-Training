//Create a program to save odd and even numbers into odd and even arrays between 1 to the number entered by the user. Finally, print the odd and even numbers array

import java.util.Scanner;

public class OddEvenArray{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a natural number:");
        int number = input.nextInt();

        // Check for natural number
        if(number <= 0){
            System.out.println("Error: Please enter a natural number");
            input.close();
            return;
        }

        // Create arrays for odd and even numbers
        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];

        int oddIndex = 0;
        int evenIndex = 0;

        // Store odd and even numbers
        for(int i = 1; i <= number; i++){
            if(i % 2 == 0){
                even[evenIndex] = i;
                evenIndex++;
            }
			else{
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers
        System.out.println("\nOdd Numbers:");
        for(int i = 0; i < oddIndex; i++){
            System.out.print(odd[i]+ " ");
        }

        // Print even numbers
        System.out.println("\n\nEven Numbers:");
        for(int i = 0; i < evenIndex; i++){
            System.out.print(even[i]+" ");
        }
        input.close();
    }
}
