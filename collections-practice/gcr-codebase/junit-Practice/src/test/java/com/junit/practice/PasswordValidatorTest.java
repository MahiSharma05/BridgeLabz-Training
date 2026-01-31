package com.junit.practice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
	PasswordValidator  validation = new PasswordValidator ();
	
	// test valid password
	@Test
	public void TestValidPassword() {
		assertTrue(validation.isValidPassword("Mahisharma123"));
	}
	
	// test atleast 8 characters
	@Test
	public void Test8Charcter() {
		assertFalse(validation.isValidPassword("Mahi"));
	}
	
	// test Upper Case
		@Test
		public void TestUppercase() {
			assertFalse(validation.isValidPassword("mahi12345"));
		}

		// test one digit
				@Test
				public void TestOneDigit() {
					assertFalse(validation.isValidPassword("mahisharma"));
				}
}
