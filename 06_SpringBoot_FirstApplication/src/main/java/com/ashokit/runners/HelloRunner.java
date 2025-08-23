package com.ashokit.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloRunner implements CommandLineRunner {
	
	public HelloRunner() {
		System.out.println("HelloRunner Class Constructors....");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HelloRunner CommandLine Args:::" + Arrays.toString(args));
	}
}