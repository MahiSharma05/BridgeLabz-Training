import java.util.Scanner;

public class InvoiceGeneratorWithException {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter invoice details:");
        System.out.println("Format: Logo Design - 3000 INR, Web Page - 4500 INR");
        System.out.print("Input: ");

        String s = input.nextLine();

        try {
            String[] tasks = parseInvoice(s);

            System.out.println("\nInvoice Details:");
            for(String task : tasks) {
                System.out.println(task.trim());
            }

            int totalAmount = getTotalAmount(tasks);
            System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");

        } 
        catch (InvalidInvoiceFormatException e){
            System.out.println("\nError: " + e.getMessage());
        }

        input.close();
    }
    // Custom Exception 
    static class InvalidInvoiceFormatException extends Exception {
        public InvalidInvoiceFormatException(String message) {
            super(message);
        }
    }

    //parse invoice input
    public static String[] parseInvoice(String input)
            throws InvalidInvoiceFormatException {

        if(input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input is empty");
        }

        String[] tasks = input.split(",");

        for (String task : tasks){
            if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format: Missing '-' in task -> " + task.trim());
            }
            String[] parts = task.split("-");

            if(parts.length != 2) {
                throw new InvalidInvoiceFormatException(
                        "Invalid format after '-' in task -> " + task.trim());
            }

            String amountPart = parts[1].trim();

            // Validate amount format (e.g., 3000 INR)
            if (!amountPart.matches("\\d+\\s+INR")) {
                throw new InvalidInvoiceFormatException(
                        "Invalid or missing amount in task -> " + task.trim());
            }
        }

        return tasks;
    }

    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks)
            throws InvalidInvoiceFormatException {

        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");
            String amountPart = parts[1].trim(); // "3000 INR"
            String amount = amountPart.split(" ")[0];

            try {
                total += Integer.parseInt(amount);
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException(
                        "Amount is not a valid number in task -> " + task.trim());
            }
        }

        return total;
    }
}
