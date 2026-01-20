package Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		Manager manager = new Manager("Alice" , 80000);
		Developer developer = new Developer("Bob" , 90000);
		manager.display();
		developer.display();
	}

}
