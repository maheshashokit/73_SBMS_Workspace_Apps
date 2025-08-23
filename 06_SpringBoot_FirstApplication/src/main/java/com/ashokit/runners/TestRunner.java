package com.ashokit.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {
	
	public TestRunner() {
		System.out.println("TestRunners Class Constructors....");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("TestRunner CommandLine Args:::" + Arrays.toString(args));
	}
}