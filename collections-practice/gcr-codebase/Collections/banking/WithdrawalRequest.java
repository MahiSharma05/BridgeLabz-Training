package banking;
public class WithdrawalRequest {

    private int accountNumber;
    private int amount;

    public WithdrawalRequest(int accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }
}

