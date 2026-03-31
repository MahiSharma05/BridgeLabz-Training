package Employee;

public class Manager extends Employee {
	
public Manager(String name, int salary) {
	super(name, salary);
}

@Override
public double getBonus() {
	if(super.getSalary() > 10000) {
		return super.getSalary() * 0.1;
	}
	return 0.0;
}

@Override 
public void display() {
	super.display();
	System.out.println("Manager Bonus: " + getBonus());
}

}
