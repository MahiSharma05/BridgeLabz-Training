package practice2;
import java.util.*;
abstract class Account{
	String accountNumber;
	String holderName;
	double balance;
	
public Account(String accountNumber, String holderName, double balance) {
	this.accountNumber = accountNumber;
	this.holderName = holderName;
	this.balance = balance;
}
public void Deposit(double amount) {
	balance += amount;
	System.out.println("deposite sccessfully");
	
}
public abstract void withdraw(double amount);
}
class SavingAccount extends Account{

	public SavingAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void withdraw(double amount) {
		double charge = 2;
		double total = amount + charge;
		if(balance - total < 0) {
			System.out.println(" Insufficient found");
		}else {
			balance -= total;
			System.out.println("Withdraw successfully");
		}
		
	}
	
}
class CurrentAccount extends Account{

	public CurrentAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void withdraw(double amount) {
		double charge = 5;
		double total = amount + charge;
		if(balance - total < -10000) {
			System.out.println("Insufficient found");
		}
		else {
			balance -= total;
			System.out.println("Withdraw successfully");
		}
		
	}
	
}
class BussinessAccount extends Account{

	public BussinessAccount(String accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void withdraw(double amount) {
		double charge = amount * 0.01;
		double total = amount + charge;
		if(balance - total < -50000) {
			System.out.println("Insuficient found");
			
		}
		else {
			balance -= total;
			System.out.println("Withdraw successfully");
		}
		
	}
	
}
class BankManager{
	List<Account> accounts = new ArrayList<>();
	private Account findAccount(String accNo) {
		for(Account acc : accounts) {
			if(acc.accountNumber.equals(accNo)) {
				return acc;
			}
		}
		return null;
	}
	public void create(String number , String name , String type , double amount) {
		Account acc= null;
		switch(type) {
		case "SavingsAccount":
			acc = new SavingAccount(number,name,amount);
			break;
		case "CurrentAccount":
			acc = new CurrentAccount(number , name , amount);
			break;
		case "BusinessAccount":
			acc = new BussinessAccount(number , name , amount);
		}
		if (acc != null) {
		    accounts.add(acc);
		    System.out.println("Account Created: " + number);
		}
	}
	
	public void deposite(String accNo , double amount) {
		Account acc = findAccount(accNo);
		if(acc == null) {
			System.out.println("Account not found");
		}
		else {
			acc.Deposit(amount);
		}
	}
	public void withdraw(String accNo , double amount) {
		Account acc = findAccount(accNo);
		if(acc == null) {
			System.out.println("Account not found");
		}
		else {
			acc.withdraw(amount);
		}
	}
}
public class MultiTypeBankAccountMangement {

	public static void main(String[] args) {
		BankManager manager = new BankManager();
		System.out.println("input");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] parts = input.split(" ");
			String commands = parts[0];
			switch(commands) {
			case "Create":
				manager.create(parts[1] , parts[2] , parts[3] , Double.parseDouble(parts[4]));
				break;
			case "Deposit":
				manager.deposite(parts[1] , Double.parseDouble(parts[2]));
				break;
			case "Withdraw":
				manager.withdraw(parts[1] , Double.parseDouble(parts[2]));
				break;
				
			}
		}

	}

}
