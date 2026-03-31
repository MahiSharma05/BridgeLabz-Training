package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {
	
	UserRegistration userregistration = new UserRegistration();
	
	// test valid user registration
	@Test
	public void TestvalidRegistration() {
		String result = userregistration.registerUser("mahi", "mahi@123gmail.com", "abc12345");
		assertEquals("User Registered Successfully",result);
	}
	
	// test invalid user name
	@Test
	public void TestinvalidUserNmae() {
		assertThrows(IllegalArgumentException.class, () ->{
			userregistration.registerUser("","mahi@123gmail.com", "abc12345");
		});
	}
	
	// test invalid email
	@Test
	public void TestinvalidEmail() {
		assertThrows(IllegalArgumentException.class, () ->{
			userregistration.registerUser("mahi","mahi123gmail.com", "abc12345");
		});
		
	}
	
	// teat invalid password
	@Test
	public void TestinvalidPassword() {
		assertThrows(IllegalArgumentException.class, () ->{
			userregistration.registerUser("mahi","mahi@123gmail.com", "abc1");
		});
		
	}
	

    
}
