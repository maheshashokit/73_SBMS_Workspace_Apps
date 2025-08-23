package com.ashokit.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailRunner implements CommandLineRunner{

	public EmailRunner() {
		System.out.println("EmailRunner Class Constructors....");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("EmailRunner CommandLine Args:::" + Arrays.toString(args));
	}
}