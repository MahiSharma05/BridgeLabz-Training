class BankAccount {

    // Access modifiers
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Amount: " + amount);
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Amount: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    // Method to display account details
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount {

    double interestRate;

    // Constructor
    SavingsAccount(String accountNumber, String accountHolder,
            double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method demonstrating access to public and protected members
    void displaySavingsDetails() {
        System.out.println("Savings Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolder);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class
public class BankApp {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC1001", "Mahi Sharma", 5000.0);

        account.displayAccountDetails();
        System.out.println("----------------------------");

        account.deposit(2000.0);
        account.withdraw(1500.0);
        System.out.println("Updated Balance: " + account.getBalance());

        System.out.println("----------------------------");

        SavingsAccount savings = new SavingsAccount("SAV2001", "Mansi Sharma",
                10000.0, 5.5);

        savings.displaySavingsDetails();
    }
}
