package banking;
import java.util.*;

public class BankService {

    // HashMap: AccountNumber -> Balance
    private Map<Integer, Integer> accounts = new HashMap<>();

    // Queue for withdrawal requests
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add account
    public void addAccount(int accountNumber, int balance) {
        accounts.put(accountNumber, balance);
    }

    // Request withdrawal
    public void requestWithdrawal(int accountNumber, int amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    // Process withdrawals (FIFO)
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");

        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int balance = accounts.getOrDefault(request.getAccountNumber(), 0);

            if (balance >= request.getAmount()) {
                accounts.put(request.getAccountNumber(),
                        balance - request.getAmount());
                System.out.println("Withdrawal successful from Account "
                        + request.getAccountNumber());
            } else {
                System.out.println("Insufficient balance for Account "
                        + request.getAccountNumber());
            }
        }
    }

    // Display customers sorted by balance
    public void displaySortedByBalance() {

        TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            sortedMap
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
            for (Integer acc : entry.getValue()) {
                System.out.println("Account " + acc
                        + " -> Balance ₹" + entry.getKey());
            }
        }
    }
}

