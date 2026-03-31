package scenario;

import java.util.List;
import java.util.ArrayList;

// Custom exception
class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}

//Bank service interface
interface BankService {
	void checkBalance();
	void transfer(Account to, double amount)throws InsufficientBalanceException;
}

// Abstract class
abstract class Account implements BankService{
	String accountNumber;
	double balance;
	List<String> transactionHistory = new ArrayList<>();
	
	Account(String accountNumber , double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public void transfer(Account to, double amount)
	    throws InsufficientBalanceException{
		if(balance < amount) {
			throw new InsufficientBalanceException ("Insufficient Balance");
		}
		
		balance -= amount;
		to.balance += amount;
		
		transactionHistory.add("Transferred " + amount + " to" + to.accountNumber);
		to.transactionHistory.add("Received )" + amount + "from" + accountNumber);
	}
	public void checkBalance() {
		System.out.println("Balance of " + accountNumber + " :" + balance);
	}
	abstract double calculateInterest();
}

// saving Account
class SavingsAccount extends Account{
	SavingsAccount(String accNo, double balance){
		super(accNo , balance);
	}
	double calculateInterest() {
		return balance * 0.04;
	}
}
class CurrentAccount extends Account{
	CurrentAccount(String accNo, double balance){
		super(accNo , balance);
	}
	double calculateInterest() {
		return balance * 0.02;
	}
}

//Transaction Thread
class TransactionThread extends Thread{
	Account From;
	Account to;
	double amount;
	
	TransactionThread(Account from , Account to , double amount){
		this.From = from;
		this.to = to;
		this.amount = amount;
	}
	public void run() {
		try {
			From.transfer(to,amount);
			System.out.println("Transfer successful:" + amount);
		}
		catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}
public class OnlineBankingSystem {

	public static void main(String[] args) {
		Account acc1 = new SavingsAccount("SA101", 2000);
        Account acc2 = new CurrentAccount("CA201", 5000);

        acc1.checkBalance();
        acc2.checkBalance();

        // Multithreading 
        Thread t1 = new TransactionThread(acc1, acc2, 3000);
        Thread t2 = new TransactionThread(acc1, acc2, 4000);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAfter Transactions:");
        acc1.checkBalance();
        acc2.checkBalance();
        
        System.out.println("\n Transaction History (Account 1):");
        for (String t : acc1.transactionHistory) {
            System.out.println(t);
        }
	}

}

