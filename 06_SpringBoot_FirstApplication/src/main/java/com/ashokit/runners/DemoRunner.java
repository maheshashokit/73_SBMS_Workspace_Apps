package com.ashokit.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
	
	public DemoRunner() {
		System.out.println("DemoRunner Class Constructors....");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("DemoRunner CommandLine Args:::" + Arrays.toString(args));
	}
}