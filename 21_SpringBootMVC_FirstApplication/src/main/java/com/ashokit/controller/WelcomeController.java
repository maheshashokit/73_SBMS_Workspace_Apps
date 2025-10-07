package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/wishes", method=RequestMethod.GET)
	public String generateWelcomeMessage(Model model) {
	   model.addAttribute("Message", "Welcome To Ashok IT For Spring Boot MVC Development.....");
	   return "welcome";
	}
	
	@GetMapping(value = "/wishByUser")
	public ModelAndView generateWishesByUser(@RequestParam("username") String username) {
	   ModelAndView mav = new ModelAndView("welcome");
	   mav.addObject("wishMessage",String.format("Welcome To Ashok IT For Spring Boot MVC Development ...%s", username));
	   return mav;
	}
}
