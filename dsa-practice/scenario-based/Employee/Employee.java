package Employee;

public abstract class Employee {
	private final String name;
	private final int salary;
	
public Employee(String name ,  int salary) {
	this.name = name;
	this.salary = salary;
}

public String getName() {
	return name;
}

public int getSalary() {
	return salary;
}

abstract double getBonus();

public void display() {
	System.out.println(" Name: " + name);
	System.out.println("Salary: " + salary);
}

}
