package banking;
public class BankMain {

    public static void main(String[] args) {

        BankService bankService = new BankService();

        // Add accounts
        bankService.addAccount(101, 5000);
        bankService.addAccount(102, 12000);
        bankService.addAccount(103, 8000);

        // Withdrawal requests
        bankService.requestWithdrawal(101, 2000);
        bankService.requestWithdrawal(103, 9000);
        bankService.requestWithdrawal(102, 3000);

        // Process withdrawals
        bankService.processWithdrawals();

        // Display sorted balances
        bankService.displaySortedByBalance();
    }
}
