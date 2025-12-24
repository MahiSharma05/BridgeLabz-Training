//Create a program to find the bonuses of employees based on their years of service.

import java.util.Scanner;

public class EmployeeBonus{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
		
        System.out.println("Enter employee salary:");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int years = input.nextInt();

        // Check bonus eligibility
        if(years > 5){
            double bonus = salary * 0.05;
            System.out.println("Employee is eligible for bonus.");
            System.out.println("Bonus amount :" + bonus);
        }
		else{
            System.out.println("Employee is not eligible for bonus.");
            System.out.println("Bonus amount : 0");
        }
        input.close();
    }
}
