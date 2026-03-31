class Employee {

    // Access modifiers
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    // Method to display employee details
    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

// Subclass Manager
class Manager extends Employee {

    String managerLevel;

    // Constructor
    Manager(int employeeID, String department,
            double salary, String managerLevel) {
        super(employeeID, department, salary);
        this.managerLevel = managerLevel;
    }

    // Method demonstrating access to public and protected members
    void displayManagerDetails() {
        System.out.println("Manager ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Manager Level: " + managerLevel);
    }
}

public class EmployeeApp {
    public static void main(String[] args) {

        Employee emp = new Employee(101, "IT", 45000.0);

        emp.displayEmployeeDetails();
        System.out.println("----------------------------");

        emp.setSalary(50000.0);
        System.out.println("Updated Salary: " + emp.getSalary());

        System.out.println("----------------------------");

        Manager mgr = new Manager(201, "HR", 80000.0, "Senior");

        mgr.displayManagerDetails();
    }
}
