// Write a program to find the sum of n natural numbers using loop


import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int result = findSum(num);

        System.out.println("The sum of " + num + " natural numbers is " + result);
        input.close();
    }
	
	// Method to find sum of n natural numbers using loop
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
