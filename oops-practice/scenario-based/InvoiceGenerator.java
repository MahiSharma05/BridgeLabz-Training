public class InvoiceGenerator {

    // Method to parse invoice input into tasks
    public static String[] parseInvoice(String input) {
        return input.split(",");
    }

    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            // Example: "Logo Design - 3000 INR"
            String[] parts = task.split("-");

            // Extract amount part
            String amountPart = parts[1].trim(); // "3000 INR"
            String amount = amountPart.split(" ")[0]; // "3000"

            total += Integer.parseInt(amount);
        }

        return total;
    }

    public static void main(String[] args) {
        String invoiceInput = "Logo Design - 3000 INR, Web Page - 4500 INR";

        // Parse invoice
        String[] tasks = parseInvoice(invoiceInput);

        // Display tasks
        System.out.println("Invoice Details:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }

        // Calculate total
        int totalAmount = getTotalAmount(tasks);
        System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");
    }
}
