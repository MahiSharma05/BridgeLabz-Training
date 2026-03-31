//Write a program to calculate simple interest.

import java.util.Scanner;

public class SimpleInterest{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the principal: ");
        double principal = input.nextDouble();

        System.out.print("Enter the rate: ");
        double rate = input.nextDouble();
		
		System.out.print("Enter the time: ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println("simple interest: " + simpleInterest);

        input.close();
    }
}
