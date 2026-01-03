package com.ashokit;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

public class SamplePasswordEncoder {

	public static void main(String[] args) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		System.out.println("Mahesh::::Mahesh@123:::::" + bCryptPasswordEncoder.encode("Mahesh@123"));
		System.out.println("Suresh::::Suresh@123:::::" + bCryptPasswordEncoder.encode("Suresh@123"));
		System.out.println("Ashok ::::Ashok@123:::::" + bCryptPasswordEncoder.encode("Ashok@123"));
		System.out.println("Ramesh::::Ramesh@123:::::" + bCryptPasswordEncoder.encode("Ramesh@123"));
		System.out.println("*************Different Series*****************");

		BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder(BCryptVersion.$2Y);

		System.out.println("Username::::" + bCryptPasswordEncoder1.encode("Mahesh"));
		System.out.println("Password::::" + bCryptPasswordEncoder1.encode("Ashok@123"));
	
	}

}
