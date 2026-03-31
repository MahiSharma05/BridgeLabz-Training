package employeeLeaveManagementSystem;

import java.util.Scanner;

public class LeaveManagementApp {

    public static void main(String[] args) {

        LeaveService service = new LeaveService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Employee Leave Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Apply Leave");
            System.out.println("3. Approve Leave");
            System.out.println("4. Reject Leave");
            System.out.println("5. View Employees");
            System.out.println("6. View Leave Requests");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Leave Balance: ");
                        int balance = sc.nextInt();

                        service.addEmployee(
                                new Employee(name, id, balance));
                        break;

                    case 2:
                        System.out.print("Enter Employee ID: ");
                        int empId = sc.nextInt();

                        System.out.print("Enter Number of Leave Days: ");
                        int days = sc.nextInt();

                        service.applyLeave(empId, days);
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        service.approveLeave(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Employee ID: ");
                        service.rejectLeave(sc.nextInt());
                        break;

                    case 5:
                        service.displayEmployees();
                        break;

                    case 6:
                        service.displayLeaveRequests();
                        break;

                    case 7:
                        System.out.println("Exiting Program...");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (InsufficientLeaveBalanceException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
