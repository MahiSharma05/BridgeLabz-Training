package FunctionalInterfaces;

interface PaymentProcessor {

    // existing abstract method 
    void processPayment(double amount);

    // New feature added later WITHOUT breaking old implementations
    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed using default refund method.");
    }
}

// Old payment provider
class CreditCardPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card payment of ₹" + amount + " successful.");
    }
}

// Another provider
class UpiPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("UPI payment of ₹" + amount + " successful.");
    }
}

public class PaymentGatewayApp {

    public static void main(String[] args) {

        PaymentProcessor card = new CreditCardPayment();
        card.processPayment(2000);
        card.refund(500);   // Uses default method

        PaymentProcessor upi = new UpiPayment();
        upi.processPayment(1500);
        upi.refund(300);    // Uses default method
    }
}
