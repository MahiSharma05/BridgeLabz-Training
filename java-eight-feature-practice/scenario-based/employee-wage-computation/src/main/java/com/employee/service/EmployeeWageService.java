package com.employee.service;

import com.employee.dao.EmployeeWageDAO;
import com.employee.model.CompanyEmployeeWage;


 // UC11 - Interface Approach
 
interface IEmpWageService {
    void addCompany(String name, int wagePerHour,
                    int maxDays, int maxHours);

    void computeWage();
}


 // Contains Business Logic

public class EmployeeWageService implements IEmpWageService {
	// UC3
    private static final int IS_PART_TIME = 1;   
    private static final int IS_FULL_TIME = 2;

    private static final int PART_TIME_HOUR = 8; 
    private static final int FULL_TIME_HOUR = 8;

    private EmployeeWageDAO dao = new EmployeeWageDAO();

    // UC8 - Add company
    @Override
    public void addCompany(String name, int wagePerHour,
                           int maxDays, int maxHours) {

        CompanyEmployeeWage company =
                new CompanyEmployeeWage(name, wagePerHour, maxDays, maxHours);

        dao.addCompany(company);
    }

    // UC4, UC5 - Monthly Wage with 20 days & 100 hrs condition
    @Override
    public void computeWage() {

        for (CompanyEmployeeWage company : dao.getCompanyList()) {

            int totalHours = 0;
            int totalDays = 0;
            int totalWage = 0;

            while (totalHours <= company.getMaxWorkingHours()
                    && totalDays < company.getMaxWorkingDays()) {

                totalDays++;

                int empCheck = (int) (Math.random() * 3);
                int empHours = 0;

                // UC3 - Switch Case
                switch (empCheck) {

                    case IS_PART_TIME:
                        empHours = PART_TIME_HOUR;
                        break;

                    case IS_FULL_TIME:
                        empHours = FULL_TIME_HOUR;
                        break;

                    default:
                        empHours = 0;
                }

                totalHours += empHours;

                int dailyWage = empHours * company.getWagePerHour();
                totalWage += dailyWage;

                // UC13 - Store daily wage
                company.addDailyWage(dailyWage);
            }

            company.setTotalEmpWage(totalWage);

            System.out.println("Total Wage for Company: "
                    + company.getCompanyName()
                    + " = " + totalWage);
        }
    }

    // UC13 - Get total wage by company
    public int getTotalWage(String companyName) {
        return dao.getTotalWage(companyName);
    }
}
