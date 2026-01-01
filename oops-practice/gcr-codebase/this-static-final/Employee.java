public class Employee {
  static String companyName = "Tech Solutions Inc";
  String name;
  final int id;
  String destination;
  static int totalEmployee = 0;

  Employee(String name, int id, String destination) {
    this.name = name;
    this.id = id;
    this.destination = destination;
    totalEmployee++;
  }

  public void displayDetails() {
    if (this instanceof Employee) {
      System.out.println("companyName: " + companyName);
      System.out.println("ID: " + id);
      System.out.println("Name: " + name);
      System.out.println("Destination: " + destination);
    } else {
      System.out.println("Invalid Employee instance");
    }
  }

  static void displayTotalEmployee() {
    System.out.println("TotalEmployee: " + totalEmployee);
  }

  public static void main(String[] args) {
    Employee e1 = new Employee("Thamarai", 101, "Software Engineer");

        Employee e2 = new Employee("Rohan", 102, "Project Manager");

    displayTotalEmployee();
    e1.displayDetails();
    e2.displayDetails();
  }
}
