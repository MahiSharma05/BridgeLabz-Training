package courierscheduler;

import java.util.*;

public class ShiftScheduler {

    private List<Employee> employees = new ArrayList<>();
    private Map<ShiftTime, List<Employee>> shiftMap = new HashMap<>();

    public ShiftScheduler() {
        // Initialize map with empty lists
        for (ShiftTime shift : ShiftTime.values()) {
            shiftMap.put(shift, new ArrayList<>());
        }
    }

    // add employee to company
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // assign shift
    public void assignShift(Employee employee, ShiftTime shift)
            throws ShiftAlreadyAssignedException {

        // Check if employee already assigned to this shift
        List<Employee> assignedEmployees = shiftMap.get(shift);

        if (assignedEmployees.contains(employee)) {
            throw new ShiftAlreadyAssignedException(
                    "Employee already assigned to " + shift + " shift.");
        }

        assignedEmployees.add(employee);
        System.out.println(employee + " assigned to " + shift + " shift.");
    }

    // Display
    public void displayShifts() {

        for (ShiftTime shift : shiftMap.keySet()) {
            System.out.println("\n" + shift + " Shift:");
            for (Employee e : shiftMap.get(shift)) {
                System.out.println(e);
            }
        }
    }
}
