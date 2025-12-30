import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Initial smart card balance
        double balance = 200.0;

        while (balance > 0) {

            System.out.println("\nCurrent Balance: ₹" + balance);
            System.out.print("Enter distance in km (or -1 to quit): ");
            double distance = input.nextDouble();

            // Exit condition
            if (distance == -1) {
                break;
            }

            // Fare calculation using ternary operator
            double fare = (distance <= 5) ? 10 :
                          (distance <= 15) ? 20 : 30;

            // Check sufficient balance
            if (fare <= balance) {
                balance = balance - fare;
                System.out.println("Fare deducted: ₹" + fare);
                System.out.println("Remaining balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("\nSmart card balance exhausted or user exited.");
        input.close();
    }
}
