//Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement

import java.util.Scanner;

public class SumUntilZeroOrNegative{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        double total = 0.0;

        while (true) {
            System.out.println("Enter a number 0 or negative to stop): ");
            double num = input.nextDouble();

            // Check stopping condition
            if (num <= 0) {
                break;
            }

            // Add to total
            total = total + num;
        }
        System.out.println("Total sum = " + total);
    }
}
