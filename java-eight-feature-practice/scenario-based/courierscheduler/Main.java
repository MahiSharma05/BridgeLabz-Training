package courierscheduler;

public class Main {

    public static void main(String[] args) {

        ShiftScheduler scheduler = new ShiftScheduler();

        Employee e1 = new Employee(101, "Rahul");
        Employee e2 = new Employee(102, "Priya");
        Employee e3 = new Employee(103, "Mahi");

        scheduler.addEmployee(e1);
        scheduler.addEmployee(e2);
        scheduler.addEmployee(e3);

        try {
            scheduler.assignShift(e1, ShiftTime.MORNING);
            scheduler.assignShift(e2, ShiftTime.AFTERNOON);
            scheduler.assignShift(e1, ShiftTime.MORNING); // duplicate
        } catch (ShiftAlreadyAssignedException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        scheduler.displayShifts();
    }
}
