package com.ashokit.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class EmployeeController {

	public EmployeeController() {
		System.out.println("EmployeeController Constructor....");
	}
}
