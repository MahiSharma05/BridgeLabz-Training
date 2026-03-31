package BankingAccount;

public class SavingsAccount extends BankingAccount {
	
public SavingsAccount(String accountNumber, double balance) {
	super(accountNumber , balance);
}

@Override
public double calculateFee() {
	return getBalance() * 0.005;
}
}
