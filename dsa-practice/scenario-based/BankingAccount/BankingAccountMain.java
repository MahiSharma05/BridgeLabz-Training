package BankingAccount;

public class BankingAccountMain {

	public static void main(String[] args) {
		BankingAccount saving = new SavingsAccount("12345", 1000.0);
        saving.display();
        BankingAccount checking = new CheckingAccount("54321", 500.0);
        checking.display();
	}
}
