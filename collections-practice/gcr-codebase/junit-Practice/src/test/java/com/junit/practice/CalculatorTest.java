package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(5, calculator.divide(10, 2));
    }

    // Bonus: division by zero
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0));
    }
}