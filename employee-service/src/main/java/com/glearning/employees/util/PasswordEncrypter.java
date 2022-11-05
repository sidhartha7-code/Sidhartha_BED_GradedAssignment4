package com.glearning.employees.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {
	public static void main(String args[]) {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String plainText="welcome";
		
		String encodedPasswordString=passwordEncoder.encode(plainText);
		
		System.out.println(encodedPasswordString);
		
		System.out.println(passwordEncoder.matches(plainText,encodedPasswordString));
	}
}
