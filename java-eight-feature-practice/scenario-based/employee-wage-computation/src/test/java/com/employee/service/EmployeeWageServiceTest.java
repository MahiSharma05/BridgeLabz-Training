package com.employee.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeeWageServiceTest {

	// test case for add company
    @Test
    void testAddCompany() {

        EmployeeWageService service = new EmployeeWageService();
        service.addCompany("TestCompany", 20, 20, 100);

        // If no exception occurs, test passes
        assertTrue(true);
    }
    
    // test case for compute and get total wage
    @Test
    void testComputeAndGetTotalWage() {

        EmployeeWageService service = new EmployeeWageService();

        service.addCompany("TCS", 20, 20, 100);
        service.computeWage();

        int totalWage = service.getTotalWage("TCS");

        assertTrue(totalWage >= 0);
    }
    
    // test invalid company
    @Test
    void testInvalidCompany() {

        EmployeeWageService service = new EmployeeWageService();

        int wage = service.getTotalWage("Unknown");

        assertEquals(-1, wage);
    }


}
