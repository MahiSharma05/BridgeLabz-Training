package Collectors;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryCategorization {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Mahi", "IT", 50000),
                new Employee("Riya", "IT", 70000),
                new Employee("Deepa", "HR", 40000),
                new Employee("Rahul", "Sales", 45000),
                new Employee("Mansi", "Sales", 55000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                                 Employee::getDepartment,
                                 Collectors.averagingDouble(Employee::getSalary)
                         ));

        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " → " + avgSalary)
        );
    }
}

