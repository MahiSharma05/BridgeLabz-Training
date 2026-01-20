package BankingAccount;

public abstract class BankingAccount {
    private final String accountNumber;
	private double balance;
public BankingAccount(String accountNumber, double balance) {
	this.accountNumber = accountNumber;
	this.balance = balance;
}
public String getAccountNumber() {
	return accountNumber;
}
public double getBalance() {
	return balance;
}

abstract double calculateFee();

public void display() {
	System.out.println(" Account Number: " + accountNumber);
	System.out.println(" balance: " + balance);
	System.out.println(" Fee: " + calculateFee());
}

}
