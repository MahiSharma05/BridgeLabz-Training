package com.junit.practice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
	BankAccount account = new BankAccount();
	
	// Test deposite
	@Test
	public void TestDeposite() {
		account.deposit(1000);
		assertEquals(1000,account.getBalance() );
	}
	
	@Test
	// Test withdraw
	public void TestWithdraw() {
		account.deposit(500);
		account.withdraw(100);
		assertEquals(400, account.getBalance());
	}
	
	// Test insufficient amount
	@Test
	public void TestWithdrawInsufficientAmount() {
		account.deposit(500);
		assertThrows(IllegalArgumentException.class,  ()->{
			account.withdraw(800);
		});
	}
}
