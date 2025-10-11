package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entites.Enquiry;
import com.ashokit.services.EnquiryService;

@Controller
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	//Getting Home page
	@GetMapping(value = "/")
	public String getHomePage(ModelMap modelMap) {
		 modelMap.addAttribute("enquiry", new Enquiry());
		 modelMap.addAttribute("enquires", enquiryService.showAllEnquires());
		 modelMap.addAttribute("title", "Welcome To Spring Boot Development Using Thymeleaf App Chennai.....");
		 return "enquires";
	}
	
	//Editing the Enquiry Details
	@GetMapping(value="/editEnquiry/{id}")
	public String editEnquiryDetails(@PathVariable("id") int enquiryId,ModelMap modelMap) {
		
		Enquiry editEnquiryDetails = enquiryService.getEnquiryById(enquiryId);
		modelMap.addAttribute("enquiryDetails", editEnquiryDetails);
		modelMap.addAttribute("title", "Welcome To Spring Boot Development Using Thymeleaf.....");
		
		return "edit_enquiry";
	}
	
	//Saving the Enquiry information
	@PostMapping(value="/saveEnquiry")
	public String updateEnquiryDetails(@ModelAttribute("enquiryDetails") Enquiry enquiry) {
		enquiry.setCreatedDate(new java.util.Date());
		boolean updateStatus = enquiryService.saveEnquiryDetails(enquiry);
		if(updateStatus) {
		  return "redirect:/";
		}else {		
		  return "";
		}
	}
	
	//Deleting enquiry Information
	@GetMapping("/deleteEnquiry/{id}")
	public String deleteEnquiryDetails(@PathVariable("id") int enquiryId) {
		enquiryService.deleteEnquiryDetails(enquiryId);
		return "redirect:/";
	}
}