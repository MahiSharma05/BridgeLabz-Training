//Create a program to count the number of digits in an integer.

import java.util.Scanner;

public class CountDigits{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer:");
        int number = input.nextInt();
        int count = 0;

        // Loop until number becomes 0
        while(number != 0){
            // Step 4: Remove last digit
            number = number / 10;
            // Step 5: Increase count
            count++;
        }
        System.out.println("Number of digits: "+ count);
        input.close();
    }
}
