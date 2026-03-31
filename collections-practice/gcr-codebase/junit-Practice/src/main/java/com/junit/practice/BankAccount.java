package com.junit.practice;

public class BankAccount {
	private double balance = 0.0;
	
	public void deposit(double amount) {
		if(amount <= 0) {
			throw new IllegalArgumentException("Invalid amount");
		}
		balance +=  amount;
	}
	
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new IllegalArgumentException("Insufficient balace");
		}
		balance -= amount;
	}
	
	public double getBalance() {
		return balance;
	}
	

}
