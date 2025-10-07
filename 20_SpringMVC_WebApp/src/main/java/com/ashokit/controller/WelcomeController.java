package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Helper controller
@Controller
public class WelcomeController {	
	
	//RequestProcessor Method
	@RequestMapping(value="welcome")
	public ModelAndView getWelcomePage() {
		
		//Creating ModelAndView Object
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("message", "Welcome To AshokIt For SpringMVC WebApplication Development!!!!");
		
		return mav;
	}

}
