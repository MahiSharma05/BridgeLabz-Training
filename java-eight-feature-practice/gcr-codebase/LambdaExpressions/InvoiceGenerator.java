package LambdaExpressions;
import java.util.*;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}

public class InvoiceGenerator {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001", "TXN1002", "TXN1003"
        );

        List<Invoice> invoices = transactionIds.stream()
                                                .map(Invoice::new)
                                                .toList();

        invoices.forEach(System.out::println);
    }
}

