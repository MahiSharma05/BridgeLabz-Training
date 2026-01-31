package com.junit.practice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DivisionTest {
	
	@Test
	public void testException() {
		Division division = new Division();
		assertThrows(ArithmeticException.class, () -> division.divide(10, 0));
	}

}
