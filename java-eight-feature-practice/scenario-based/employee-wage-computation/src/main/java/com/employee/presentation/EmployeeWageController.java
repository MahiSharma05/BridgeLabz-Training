package com.employee.presentation;

import com.employee.service.EmployeeWageService;


 // UC0 - Welcome Message

public class EmployeeWageController {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        EmployeeWageService service = new EmployeeWageService();

        // UC8 - Multiple Companies
        service.addCompany("Capgemini", 20, 20, 100);
        service.addCompany("Infosys", 25, 22, 120);

        service.computeWage();

        // UC13 - Query total wage
        System.out.println("Queried Wage for TCS: "
                + service.getTotalWage("Capgemini"));
    }
}
