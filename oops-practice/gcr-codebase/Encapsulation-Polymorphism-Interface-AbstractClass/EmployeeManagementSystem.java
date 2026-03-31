package oopsConcepts;
import java.util.Scanner;

// Interface
interface Department{
	void assignDepartment(String dept);
	String getDepartmentDetails();
}

// abstract class
abstract class Employee{
	private int employeeId;
	private String name;
	private double baseSalary;
Employee (int employeeId , String name , double baseSalary  ){
	this.employeeId = employeeId;
	this.name = name;
	this.baseSalary = baseSalary;
}

// Getters and Setters
public int getEmployeeId() {
	return employeeId;
}
public String getName() {
	return name;
}
public double getBaseSalary() {
	return baseSalary;
}

public void setBaseSalary(double baseSalary) {
	this.baseSalary = baseSalary;
}

// abstract method
abstract double calculateSalary();

// Concreate method
void displayDetails() {
	System.out.println("Employee ID: " + employeeId);
	System.out.println("Nmae: " + name);
	System.out.println("Salary: " + calculateSalary());
	
}

}

// full time employee
class FullTimeEmployee extends Employee implements Department{
	private String department;
FullTimeEmployee(int id , String name , double fixedSalary){
	super(id , name , fixedSalary);
}
	
@Override
double calculateSalary() {
	return getBaseSalary();
}
@Override
public void assignDepartment(String dept) {
	this.department = dept;
}
@Override
public String getDepartmentDetails() {
	return department;
}
}

// part time employee
class PartTimeEmployee extends Employee{
	private int hoursWorked;
	private double hourlyRate;
	private String department;
PartTimeEmployee(int employeeId , String name , double hourlyRate , int hoursWorked){
	super(employeeId , name , 0);
	this.hourlyRate = hourlyRate;
	this.hoursWorked = hoursWorked;
}

@Override
double calculateSalary() {
	return hourlyRate * hoursWorked;
}

public void assignDepartment(String dept) {
	this.department = dept;
}

public String getDepartmentDetails() {
	return department;
}
}

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of employee: ");
		int n = input.nextInt();
		
		Employee[] emp = new Employee[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Employee " + (i + 1));
			System.out.println("Employee ID ");
			int id = input.nextInt();
			
			input.nextLine();
			System.out.println("Enter name :");
			String name = input.nextLine();
			
			System.out.println("Enetr 1 for full time , Enter 2 for part time");
			int type  = input.nextInt();
			if(type == 1) {
				System.out.println("Enter fixed salary");
				double salary = input.nextDouble();
				emp[i] = new FullTimeEmployee(id , name , salary);
			}
			else {
				System.out.println("Enter hourly Rate:");
				double rate = input.nextDouble();
				System.out.println("Enter Hours Worked:");
				int hours = input.nextInt();
				emp[i] = new PartTimeEmployee(id ,name , rate , hours);
			}
			
			input.nextLine();
			System.out.println("Enter Department");
			String dept = input.nextLine();
			if (emp[i] instanceof Department) {
			    Department d = (Department) emp[i];
			    d.assignDepartment(dept);
			}

		}
        System.out.println(".....Employee Details.....");
        for(Employee e : emp) {
        	e.displayDetails();
        	System.out.println("Department: " + ((Department) e).getDepartmentDetails());
        }
        input.close();
	}

}
