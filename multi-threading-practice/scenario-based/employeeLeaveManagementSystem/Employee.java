package employeeLeaveManagementSystem;

public class Employee {

    private String employeeName;
    private int employeeId;
    private int leaveBalance;

    public Employee(String employeeName, int employeeId, int leaveBalance) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.leaveBalance = leaveBalance;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    @Override
    public String toString() {
        return "Employee Name: " + employeeName +
               ", Employee ID: " + employeeId +
               ", Leave Balance: " + leaveBalance;
    }
}
