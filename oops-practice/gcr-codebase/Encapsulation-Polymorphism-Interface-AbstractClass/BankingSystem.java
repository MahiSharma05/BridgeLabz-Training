package oopsConcepts;
import java.util.ArrayList;


public class BankingSystem{

	public static void main(String[] args){
		ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Mahi", 8000));
        accounts.add(new CurrentAccount("CA202", "Mansi", 15000));

        System.out.println("... Banking System Details...\n");

        for (BankAccount acc : accounts) {

            acc.displayAccount();

            // Polymorphism: dynamic method call
            double interest = acc.calculateInterest();
            System.out.println("Calculated Interest: " + interest);

            // Loan processing using interface
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(50000);

                if (loanAcc.calculateLoanEligibility()) {
                    System.out.println("Loan Status: Eligible");
                }
                else {
                    System.out.println("Loan Status: Not Eligible");
                }
            }

            System.out.println(".................................\n");
        }
    }

	}
	//Interface
	interface Loanable {
	    void applyForLoan(double amount);
	    boolean calculateLoanEligibility();
	}

	// Abstract Class
	abstract class BankAccount {

	    // Encapsulation
	    private String accountNumber;
	    private String holderName;
	    private double balance;

	    BankAccount(String accountNumber, String holderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.holderName = holderName;
	        this.balance = balance;
	    }

	    // Getters 
	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public String getHolderName() {
	        return holderName;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    // Concrete methods
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited: " + amount);
	        } 
	        else {
	            System.out.println("Invalid deposit amount");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	        }
	        else {
	            System.out.println("Insufficient balance or invalid amount");
	        }
	    }

	    // Abstract method
	    abstract double calculateInterest();

	    // Common display method
	    void displayAccount() {
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Holder Name: " + holderName);
	        System.out.println("Balance: " + balance);
	    }
	}

	//  Savings Account 
	class SavingsAccount extends BankAccount implements Loanable {

	    private static final double INTEREST_RATE = 0.04; 
	    private double requestedLoanAmount;

	    SavingsAccount(String accNo, String name, double balance) {
	        super(accNo, name, balance);
	    }

	    @Override
	    double calculateInterest() {
	        return getBalance() * INTEREST_RATE;
	    }

	    public void applyForLoan(double amount) {
	        requestedLoanAmount = amount;
	        System.out.println("Savings Account Loan Applied: " + amount);
	    }

	    public boolean calculateLoanEligibility() {
	        return getBalance() >= 5000;
	    }
	}

	// Current Account
	class CurrentAccount extends BankAccount implements Loanable {

	    private static final double INTEREST_RATE = 0.02; 
	    private double requestedLoanAmount;

	    CurrentAccount(String accNo, String name, double balance) {
	        super(accNo, name, balance);
	    }

	    @Override
	    double calculateInterest() {
	        return getBalance() * INTEREST_RATE;
	    }

	    public void applyForLoan(double amount) {
	        requestedLoanAmount = amount;
	        System.out.println("Current Account Loan Applied: " + amount);
	    }

	    public boolean calculateLoanEligibility() {
	        return getBalance() >= 10000;
	    }
	}

