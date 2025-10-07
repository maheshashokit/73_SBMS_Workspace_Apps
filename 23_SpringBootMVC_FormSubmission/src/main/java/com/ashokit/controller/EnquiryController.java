package com.ashokit.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashokit.beans.EnquiryDTO;
import com.ashokit.entity.Enquiry;
import com.ashokit.services.EnquiryService;
import com.ashokit.services.PDFGenerator;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	@Value("${enquires.pageSize}")
	private int pageSize;
	
	@Value("${enquiry.pageTitle}")
	private String pageTitle;

	
	@GetMapping(value="/")
	public ModelAndView getHomePage() {
		System.out.println("Inside the Home page");
		ModelAndView mav = new ModelAndView("enquiryDetails");
		//Binding the Form with Java Object
		mav.addObject("enquiryForm", new EnquiryDTO());
		mav.addObject("readOnly", false);
		return mav;
	}
	
	@PostMapping(value="processEnquiry")
	public String handleEnquiry(@ModelAttribute("enquiryForm") EnquiryDTO enquirydto,ModelMap map) {
		
		//EnquiryDTO contains form data 
		 System.out.println("Enquiry ID ::::: "+ enquirydto.getEnquiryId());
		 // If enquiryId is null indicates creation of enquiry record otherwise updation of enquiry detaails
		 EnquiryDTO enquiry = null;
		 if(Objects.isNull(enquirydto.getEnquiryId())) {
			 //creating the enquiry info
			 enquiry = enquiryService.createEnquiry(enquirydto);
			 map.addAttribute("enquiryStatus", "EnquiryInformation Sent out Admin Team!!!!");
		 }else {
			 //updating the enquiry Information
			 enquiryService.updateEnquiry(enquirydto);
			 map.addAttribute("enquiryStatus", "EnquiryInformation Has Been Updated!!!!");
		 }	 
		
		 return "redirect:displayEnquires";
	}
	
	@GetMapping(value="displayEnquires")
	public String displayAllEnquiredInfo(ModelMap map) {
		return showEnquiresByPage(1,map,"name","asc");		
	}
	
	@GetMapping("page/{pageNo}")
	public String showEnquiresByPage(@PathVariable(value = "pageNo") int pageNo,
									 ModelMap modelMap,
						             @RequestParam("sortField") String sortField, 
						             @RequestParam("sortDir") String sortDir) {

		Page<Enquiry> page = enquiryService.getAllEnquiresSortByPage(pageNo, pageSize,sortField,sortDir);

		// Getting the list of enquires from page object
		List<Enquiry> enquiresList = page.getContent();

		modelMap.addAttribute("title", "Welcome To AshokIT Developing SpringBoot MVC Application......");

		// pagination field attributes
		modelMap.addAttribute("currentPage", pageNo);//Request parameter
		modelMap.addAttribute("totalPages", page.getTotalPages()); // 4
		modelMap.addAttribute("totalItems", page.getTotalElements()); // 11'

		//Sort Direction related fields
		modelMap.addAttribute("sortField", sortField); //RequestParameter
		modelMap.addAttribute("sortDir", sortDir);//Request parameter
		modelMap.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		modelMap.addAttribute("pageTitle",pageTitle);

		// Page of data
		modelMap.addAttribute("enquires", enquiresList);

		return "enquiryInfo";
	}
	
	@GetMapping("/editEnquiry/{enquiryId}")
	public String editFormDetails(ModelMap map, @PathVariable("enquiryId") int enquiryId) {
		
		EnquiryDTO enquiryDetailsById = enquiryService.getEnquiryDetailsById(enquiryId);
		
		if(Objects.nonNull(enquiryDetailsById)) {
			map.addAttribute("enquiryForm",enquiryDetailsById);
		}		
		map.addAttribute("readOnly", true);
		return "enquiryDetails";		
	}
	
	@GetMapping("/deleteEnquiry/{enquiryId}")
	public String deleteEnquiryDetails(ModelMap map, @PathVariable("enquiryId") int enquiryId) {
		//Assignment for implementing respective Service method logic for deleting the enquiry details
		return "redirect:displayEnquires";		
	}
	
	@GetMapping("/export-to-pdf")
	public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=ashokit_enquires_" + currentDateTime +".pdf";
		response.setHeader(headerkey, headervalue);
		
		
		List<EnquiryDTO> listOfEnquires = enquiryService.getAllEnquires();
		
		PDFGenerator generator = new PDFGenerator();
		generator.generate(listOfEnquires, response);
	}

}
