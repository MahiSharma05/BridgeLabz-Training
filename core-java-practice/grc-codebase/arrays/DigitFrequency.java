//Create a program to take a number as input find the frequency of each digit in the number using an array and display the frequency of each digit


import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // input for a number
        System.out.print("Enter a number: ");
        long number = input.nextLong();
        long temp = number;
        int count = 0;

        // Find count of digits
        while(temp != 0){
            count++;
            temp = temp / 10;
        }

        // Create array to store digits
        int[] digits = new int[count];
        temp = number;
        int index = 0;

        // Store digits in array
        while (temp != 0){
            digits[index] = (int) (temp % 10);
            temp = temp / 10;
            index++;
        }

        // Frequency array for digits 0–9
        int[] frequency = new int[10];

        // Calculate frequency
        for (int i = 0; i < digits.length; i++){
            frequency[digits[i]]++;
        }

        //  Display frequency
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < frequency.length; i++){
            if(frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
            }
        }
        input.close();
    }
}

