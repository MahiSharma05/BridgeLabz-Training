package inheritance;

// superclass
class BankAccount{
	String accountNumber ;
	double balance;

BankAccount(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
}

void displayCommonDetails() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Balance: ₹" + balance);
    }	
	
}

// subclass
class SavingsAccount extends BankAccount{
	double interestRate ;
	
	SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        displayCommonDetails();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }	
}

// subclass
class CheckingAccount extends BankAccount{
	double withdrawalLimit ;

	CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        displayCommonDetails();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }	
}

class FixedDepositAccount  extends BankAccount{
	int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        displayCommonDetails();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

public class BankAccountTypes {

	public static void main(String[] args) {
		SavingsAccount savings = new SavingsAccount("SA101", 50000, 4.5);
        CheckingAccount checking = new CheckingAccount("CA102", 30000, 10000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD103", 100000, 24);

        savings.displayAccountType();
        System.out.println();

        checking.displayAccountType();
        System.out.println();

        fixed.displayAccountType();

	}

}
