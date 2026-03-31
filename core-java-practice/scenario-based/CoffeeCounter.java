import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String coffeeType;

        while (true) {
            System.out.print("\nEnter coffee type (Espresso/Latte/Cappuccino) or 'exit' to stop: ");
            coffeeType = input.next();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you! Cafe closed ");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            double price = 0;

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 120;
                    break;
                case "latte":
                    price = 150;
                    break;
                case "cappuccino":
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue;
            }

            double bill = price * quantity;
            double gst = bill * 0.05;   // 5% GST
            double totalAmount = bill + gst;

            System.out.println("Bill Amount: ₹" + bill);
            System.out.println("GST (5%): ₹" + gst);
            System.out.println("Total Payable: ₹" + totalAmount);
        }

        input.close();
    }
}
