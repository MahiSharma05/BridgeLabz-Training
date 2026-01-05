package scenario;

public class BankAccountManager {
	int accountNumber;
	double balance;
	
BankAccountManager(int accountNumber , double balance){
	this.accountNumber = accountNumber;
	this.balance = balance;
}
	
void Deposit(double amount) {
	if(amount > 0) {
		balance += amount;
		System.out.println("Amount deposite" + amount);
	}
	else {
		System.out.println("Invalid deposit amount");
	}
}

void Withdwar(double amount) {
	if(amount > 0 && amount <= balance) {
		balance -= amount;
		System.out.println("Amount Withdwar" + amount);
	}
	else {
		System.out.println("Invalid withdraw amount" + amount);
	}
}

void CheckBalance() {
	System.out.println("Total Amount :" + balance);
	
}

public static void main(String[] args) {
	BankAccountManager account = new BankAccountManager(234567 , 5000);
	account.CheckBalance();
	account.Deposit(1000);
	account.Withdwar(2000);
	account.CheckBalance();

	}

}
