// Employee Wage Computation Problems

import java.util.Scanner;

public class EmployeeWageComputation {

    // Constants
    static final int WAGE_PER_HOUR = 20;
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program on Master Branch.");

        int totalMonthlyWage = 0;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;

        Scanner input = new Scanner(System.in);

        // UC-6: Calculate wage till max hours or max days
        while (totalWorkingDays < MAX_WORKING_DAYS &&
               totalWorkingHours < MAX_WORKING_HOURS) {

            totalWorkingDays++;
            System.out.println("\nDay " + totalWorkingDays);

            int hours = 0;

            // UC-1: Check Employee is Present or Absent
            int attendance = (int) (Math.random() * 2);

            if (attendance == 1) {
                System.out.println("Employee is Present");

                // UC-3: Part-Time / Full-Time
                System.out.println("Enter Employee Type:");
                System.out.println("1 = Part Time");
                System.out.println("2 = Full Time");
                int empType = input.nextInt();

                // UC-4: Switch Case
                switch (empType) {
                    case 1:
                        hours = 4;
                        System.out.println("Employee is Part Time");
                        break;

                    case 2:
                        hours = 8;
                        System.out.println("Employee is Full Time");
                        break;

                    default:
                        hours = 0;
                        System.out.println("Invalid Employee Type");
                }

            } else {
                System.out.println("Employee is Absent");
                hours = 0;
            }

            // Prevent exceeding max working hours
            if (totalWorkingHours + hours > MAX_WORKING_HOURS) {
                hours = MAX_WORKING_HOURS - totalWorkingHours;
            }

            // UC-2: Calculate Daily Employee Wage
            int dailyWage = hours * WAGE_PER_HOUR;
            System.out.println("Daily Employee Wage: " + dailyWage);

            totalWorkingHours += hours;
            totalMonthlyWage += dailyWage;
        }

        // UC-5: Monthly Wage Result
        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Employee Wage: " + totalMonthlyWage);

        input.close();
    }
}
