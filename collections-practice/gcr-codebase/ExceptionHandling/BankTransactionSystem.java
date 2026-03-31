package ExceptionHandling;

//Custom Checked Exception
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

class BankAccount {
 private double balance;

 public BankAccount(double balance) {
     this.balance = balance;
 }

 // Withdraw method
 public void withdraw(double amount) throws InsufficientBalanceException {

     if (amount < 0) {
         // Unchecked exception
         throw new IllegalArgumentException("Invalid amount!");
     }

     if (amount > balance) {
         // Checked custom exception
         throw new InsufficientBalanceException("Insufficient balance!");
     }

     balance -= amount;
     System.out.println("Withdrawal successful, new balance: " + balance);
 }
}

public class BankTransactionSystem {

 public static void main(String[] args) {

     BankAccount account = new BankAccount(10000);

     try {
         account.withdraw(2000);   // Change amount to test cases

     } catch (InsufficientBalanceException e) {
         System.out.println(e.getMessage());

     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     }
 }
}

