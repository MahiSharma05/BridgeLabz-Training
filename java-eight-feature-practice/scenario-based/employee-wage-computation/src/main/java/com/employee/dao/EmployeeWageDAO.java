package com.employee.dao;

import java.util.ArrayList;
import com.employee.model.CompanyEmployeeWage;


 // UC12 - Use ArrayList to manage multiple companies
 
public class EmployeeWageDAO {

    private ArrayList<CompanyEmployeeWage> companyList = new ArrayList<>();

    public void addCompany(CompanyEmployeeWage company) {
        companyList.add(company);
    }

    public ArrayList<CompanyEmployeeWage> getCompanyList() {
        return companyList;
    }

    // UC13 - Get total wage by company
    public int getTotalWage(String companyName) {
        for (CompanyEmployeeWage company : companyList) {
            if (company.getCompanyName().equals(companyName)) {
                return company.getTotalEmpWage();
            }
        }
        return -1;
    }
}
