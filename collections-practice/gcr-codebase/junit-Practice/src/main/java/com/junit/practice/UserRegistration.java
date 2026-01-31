package com.junit.practice;

public class UserRegistration {
	
	public String registerUser(String username, String email, String password) {
		if(username == "" || username.isEmpty()) {
			throw new IllegalArgumentException("Invalid User Name");
		}
		if(email == "" || !email.contains("@")) {
			throw new IllegalArgumentException("Invalid Email");
		}
		if(password == "" || password.length() < 6) {
			throw new IllegalArgumentException("Invalid Password");
		}
		
		return "User Registered Successfully";
	} 
    
}
