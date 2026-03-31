package com.junit.practice;

public class Program {

    private double balance = 0.0;

    // Deposit Method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        balance += amount;
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;
    }

    // Getter Method
    public double getBalance() {
        return balance;
    }
}
