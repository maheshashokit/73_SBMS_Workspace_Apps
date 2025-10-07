package com.ashokit.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.dao.Enquiry;
import com.ashokit.reports.PDFGenerator;
import com.ashokit.services.EnquiryService;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@Value("${enquires.pageSize}")
	private int pageSize;

	// getting the home page when we deployed application into server automatically
	// will execute this handler method
	@GetMapping(value = "/")
	public String showAllEnquires(ModelMap map) {
		return showEnquiresByPage(1, "enquiryName", "asc", map);
	}

	@GetMapping("/page/{pageNo}")
	public String showEnquiresByPage(@PathVariable(value = "pageNo") int pageNo,
			                         @RequestParam("sortField") String sortField, 
			                         @RequestParam("sortDir") String sortDir, 
			                         ModelMap modelMap) {

		Page<Enquiry> page = enquiryService.getAllEnquiresSortByPage(pageNo, pageSize, sortField, sortDir);

		// Getting the list of enquires from page object
		List<Enquiry> enquiresList = page.getContent();

		modelMap.addAttribute("title", "Welcome To AshokIT Developing SpringBoot MVC Application......");

		// pagination field attributes
		modelMap.addAttribute("currentPage", pageNo);//Request parameter
		System.out.println("page.getTotalPages()" + page.getTotalPages());
		modelMap.addAttribute("totalPages", page.getTotalPages()); // 4
		modelMap.addAttribute("totalItems", page.getTotalElements()); // 11'
		System.out.println("page.getTotalPages()" + page.getTotalElements());

		// sorting fields attributes
		modelMap.addAttribute("sortField", sortField); //RequestParameter
		modelMap.addAttribute("sortDir", sortDir);//Request parameter
		modelMap.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		modelMap.addAttribute("enquires", enquiresList);

		return "enquires";
	}

	@GetMapping("/export-to-pdf")
	public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=ashokit_enquires_" + currentDateTime +".pdf";
		response.setHeader(headerkey, headervalue);
		List<Enquiry> listOfEnquires = enquiryService.getAllEnquires();
		PDFGenerator generator = new PDFGenerator();
		generator.generate(listOfEnquires, response);
	}
}
