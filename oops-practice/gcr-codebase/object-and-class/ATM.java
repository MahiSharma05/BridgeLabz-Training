class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display current balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Method to deposit money
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class ATM {
    public static void main(String[] args) {

        // Create BankAccount object
        BankAccount account = new BankAccount("State of Chennai", "ACC1001", 700.0);

        // Display initial state
        System.out.println(account.accountHolder);
        account.displayBalance();

        // Deposit money
        account.deposit(200.0);

        // Withdraw money
        account.withdraw(100.0);

        // Try to withdraw more than balance
        account.withdraw(1000.0);
    }
}
