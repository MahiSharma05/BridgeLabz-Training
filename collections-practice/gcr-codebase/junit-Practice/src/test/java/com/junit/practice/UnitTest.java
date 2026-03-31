package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitTest {

    Program account;

    @BeforeEach
    public void setup() {
        account = new Program();   // fresh object before each test
    }

    @Test
    public void Test_Deposit_ValidAmount() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200);
        });
        assertEquals("Deposit amount cannot be negative.", ex.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        account.deposit(500);
        account.withdraw(100);
        assertEquals(400, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        account.deposit(500);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(800);
        });
        assertEquals("Insufficient funds", ex.getMessage());
    }
}
