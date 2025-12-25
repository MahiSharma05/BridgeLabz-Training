//Create a program to find the bonus of 10 employees based on their years of service and the total bonus amount the company Zara has to pay, along with the old and new salary.

import java.util.Scanner;

public class ZaraBonusCalculator{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int n = 10;

        double[] salary = new double[n];
        double[] years = new double[n];
        double[] bonus = new double[n];
        double[] newSalary = new double[n];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input loop
        for(int i = 0; i < n; i++){
            System.out.println("\nEnter details for Employee "+ (i + 1));
            System.out.print("Enter salary: ");
            salary[i] = input.nextDouble();
            System.out.print("Enter years of service: ");
            years[i] = input.nextDouble();

            //  check validation
            if(salary[i] <= 0 || years[i] < 0){
                System.out.println("Invalid input! Please enter again.");
				// decrement index to re-enter data
                i--; 
                continue;
            }
        }

        // Bonus calculation 
        for(int i = 0; i < n; i++){
            if(years[i] > 5){
                bonus[i] = salary[i] * 0.05;
            } 
			else{
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println("\n ZARA BONUS SUMMARY ");
        System.out.println("Total Old Salary: "+ totalOldSalary);
        System.out.println("Total Bonus Payout: "+ totalBonus);
        System.out.println("Total New Salary: "+ totalNewSalary);
        input.close();
    }
}
