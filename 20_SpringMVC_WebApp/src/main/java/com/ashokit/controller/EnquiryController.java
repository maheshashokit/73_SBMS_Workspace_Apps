package com.ashokit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashokit.dto.Enquiry;

@Controller
public class EnquiryController {
	
	@RequestMapping(value="/")
	public ModelAndView getEnquiryPage() {
		//return new ModelAndView("enquiry");
		ModelAndView mav = new ModelAndView("courseEnquiry");
		mav.addObject("enquiryForm",new Enquiry());
		return mav;
	}
	
	@RequestMapping(value="sendEnquiry",method = RequestMethod.POST)
	public ModelAndView processEnquiry(@RequestParam Map<String,String> allRequestParams) {
		ModelAndView mav = new ModelAndView("confirmation");
		mav.addObject("enquiryInfo", allRequestParams);
		return mav;
	}

	
	/*@RequestMapping(value="processEnquiry",method = RequestMethod.POST)
	public ModelAndView processEnquiries(@RequestParam Map<String,String> formData) {
		ModelAndView mav = new ModelAndView("confirmation");
		
		//setting the form data into Java Object
		Enquiry enq = new Enquiry();
		enq.setFirstName(formData.get("firstName"));
		enq.setEmailId(formData.get("emailId"));
		enq.setContactNo(formData.get("contactNo"));
		enq.setCourses(formData.get("courses"));
		
		mav.addObject("enquiryInfo", enq);
		
		return mav;
	}*/
	
	@RequestMapping(value="processEnquiry",method = RequestMethod.POST)
	public ModelAndView processEnquiries(@ModelAttribute("enquiryForm") Enquiry formData) {
		ModelAndView mav = new ModelAndView("confirmation");
		
		mav.addObject("enquiryInfo", formData);
		
		return mav;
	}
}
