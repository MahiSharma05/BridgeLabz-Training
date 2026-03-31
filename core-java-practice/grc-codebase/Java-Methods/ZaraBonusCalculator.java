// Create a program to find the bonus of 10 employees based on their years of service as well as the total bonus amount the 10-year-old company Zara has to pay as a bonus, along with the old and new salary.

import java.util.Scanner;

public class ZaraBonusCalculator {

    // Method to generate salary and years of service
    public static int[][] generateEmployeeData(int employees) {
        int[][] data = new int[employees][2]; // [salary][years]

        for (int i = 0; i < employees; i++) {
            // Generate 5-digit salary (10000 to 99999)
            data[i][0] = (int)(Math.random() * 90000) + 10000;

            // Generate years of service (1 to 10)
            data[i][1] = (int)(Math.random() * 10) + 1;
        }
        return data;
    }

    // Method to calculate new salary and bonus
    public static double[][] calculateBonus(int[][] data) {
        int employees = data.length;
        double[][] result = new double[employees][2]; // [newSalary][bonus]

        for (int i = 0; i < employees; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05; // 5% bonus
            } else {
                bonus = salary * 0.02; // 2% bonus
            }

            result[i][1] = bonus;
            result[i][0] = salary + bonus;
        }
        return result;
    }

    // Method to display data and totals
    public static void displayReport(int[][] oldData, double[][] newData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("\nZARA COMPANY BONUS REPORT");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-5s %-12s %-10s %-12s %-10s\n",
                "ID", "Old Salary", "Years", "New Salary", "Bonus");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            int oldSalary = oldData[i][0];
            int years = oldData[i][1];
            double newSalary = newData[i][0];
            double bonus = newData[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-5d %-12d %-10d %-12.2f %-10.2f\n",
                    (i + 1), oldSalary, years, newSalary, bonus);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-18s : %.2f\n", "Total Old Salary", totalOldSalary);
        System.out.printf("%-18s : %.2f\n", "Total New Salary", totalNewSalary);
        System.out.printf("%-18s : %.2f\n", "Total Bonus Paid", totalBonus);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int employees = 10;

        int[][] employeeData = generateEmployeeData(employees);
        double[][] updatedData = calculateBonus(employeeData);
        displayReport(employeeData, updatedData);

        input.close();
    }
}
