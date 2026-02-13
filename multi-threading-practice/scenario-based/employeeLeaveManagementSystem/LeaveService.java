package employeeLeaveManagementSystem;

import java.util.*;

public class LeaveService {

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeId(), employee);
        System.out.println("Employee added successfully!");
    }

    // Apply Leave
    public void applyLeave(int empId, int days)
            throws InsufficientLeaveBalanceException {

        Employee emp = employeeMap.get(empId);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        if (emp.getLeaveBalance() < days) {
            throw new InsufficientLeaveBalanceException(
                    "Insufficient leave balance!");
        }

        LeaveRequest request = new LeaveRequest(empId, days);
        leaveRequests.add(request);

        System.out.println("Leave request submitted successfully!");
    }

    // Approve Leave
    public void approveLeave(int empId) {

        for (LeaveRequest request : leaveRequests) {
            if (request.getEmployeeId() == empId &&
                request.getStatus().equals("Pending")) {

                Employee emp = employeeMap.get(empId);

                emp.setLeaveBalance(
                        emp.getLeaveBalance() - request.getNumberOfDays());

                request.setStatus("Approved");

                System.out.println("Leave Approved Successfully!");
                return;
            }
        }

        System.out.println("No pending leave request found.");
    }

    // Reject Leave
    public void rejectLeave(int empId) {

        for (LeaveRequest request : leaveRequests) {
            if (request.getEmployeeId() == empId &&
                request.getStatus().equals("Pending")) {

                request.setStatus("Rejected");
                System.out.println("Leave Rejected Successfully!");
                return;
            }
        }

        System.out.println("No pending leave request found.");
    }

    // Display Employees
    public void displayEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employeeMap.values().forEach(System.out::println);
        }
    }

    // Display Leave Requests
    public void displayLeaveRequests() {
        if (leaveRequests.isEmpty()) {
            System.out.println("No leave requests found.");
        } else {
            leaveRequests.forEach(System.out::println);
        }
    }
}
