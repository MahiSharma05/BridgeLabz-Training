package com.junit.practice;

public class PasswordValidator {
	public boolean isValidPassword(String password) {
		if(password == null) {
			return false;
		}
		String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
		return password.matches(regex);
	}
}
