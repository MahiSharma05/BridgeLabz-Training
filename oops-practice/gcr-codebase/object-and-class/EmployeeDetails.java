class Employee {
  String name;
  int id;
  double salary;

  // Constructor
  Employee(String name, int id, double salary) {
    this.name = name;
    this.id = id;
    this.salary = salary;
  }
}

public class EmployeeDetails {
  public static void main(String[] args) {

    // Creating object using constructor
    Employee emp = new Employee("Rohan", 1, 5000);

    System.out.println("Employee Name: " + emp.name);
    System.out.println("Employee id: " + emp.id);
    System.out.println("Employee Salary: " + emp.salary);
  }
}
