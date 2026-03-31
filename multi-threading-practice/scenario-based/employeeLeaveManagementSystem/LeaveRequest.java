package employeeLeaveManagementSystem;

public class LeaveRequest {

    private int employeeId;
    private int numberOfDays;
    private String status;

    public LeaveRequest(int employeeId, int numberOfDays) {
        this.employeeId = employeeId;
        this.numberOfDays = numberOfDays;
        this.status = "Pending";   // default status
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
               ", Days: " + numberOfDays +
               ", Status: " + status;
    }
}
