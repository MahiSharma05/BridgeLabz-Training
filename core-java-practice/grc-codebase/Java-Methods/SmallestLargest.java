// Write a program to find the smallest and the largest of the 3 numbers.


import java.util.Scanner;

public class SmallestLargest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter first number: ");
        int n1 = input.nextInt();

        System.out.print("Enter second number: ");
        int n2 = input.nextInt();

        System.out.print("Enter third number: ");
        int n3 = input.nextInt();

        int[] result = smallestAndLargest(n1, n2, n3);

        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
        input.close();
    }
	
	// Method to find smallest and largest
    public static int[] smallestAndLargest(int num1, int num2, int num3) {

        int smallest = num1;
        int largest = num1;

        if(num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }

        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        return new int[]{smallest, largest};
    }
}
