package com.ashokit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ashokit.dto.UserDto;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileController {
	
	public FileController() {
		System.out.println("Request Controller class default constructor!!!");
	}
	
	//getting home page 
	@RequestMapping(value ="/",method=RequestMethod.GET)
	public String getHomePage(Model model) {
		model.addAttribute("user", new UserDto());	//creating the object for command class	
		
		//creating the content for Dropdown while rendering the registrationForm.jsp
		List<String> qualificationList = new ArrayList<String>();
		qualificationList.add("MCA");
		qualificationList.add("CSE");
		model.addAttribute("qualificationsList", qualificationList);
		
		return "registrationForm";	
	}
	
	@RequestMapping(value="saveProfile",method=RequestMethod.POST)
	public ModelAndView saveProfileData(@ModelAttribute("user") UserDto user) {
		 ModelAndView mav = new ModelAndView();
		
		 MultipartFile uploadFile = user.getProfilePic();
		
		 String uploadStatus ="Uploaded Success";
		 String viewPageName="registrationForm";
		 File totalFilesList[] = null;

		 // E:\springBootUploadFiles\
		 File directoryLocation = new File("E:"+File.separator+"springBootUploadFiles"+File.separator);		    
	  	 //checking the file location directory is existed or not
		 if(!directoryLocation.exists()) {
			directoryLocation.mkdir();
		 }
		 if(!uploadFile.isEmpty()) {
		   String uploadFileName = uploadFile.getOriginalFilename();//uploaded file name	
		   System.out.println("Absoulte Path::::" + directoryLocation.getAbsolutePath());
		   System.out.println("Upload File Name::::::" + uploadFileName);
		   //uploadedFilePath = E:\springBootUploadFiles\images3.png
		   String uploadedFilePath = directoryLocation.getAbsolutePath()+File.separator+uploadFileName;
			try(FileOutputStream fos = new FileOutputStream(uploadedFilePath)){			
				byte[] bt = uploadFile.getBytes();				
				fos.write(bt);//writing the uploaded file data into destination location
			
				totalFilesList = directoryLocation.listFiles();//getting the list of files available in directory
				viewPageName = "fileUploadStatus";
			} catch (Exception e) {	
				e.printStackTrace();
			}	
		 }else {
			 uploadStatus ="Please Browse File To Complete the Form Submission!!!";			 
		 }
		 mav.addObject("totalFilesList", totalFilesList);
		 mav.addObject("uploadStatus",uploadStatus);
		 mav.setViewName(viewPageName);
		 return mav;
	}
	
	@RequestMapping(value="downloadFile", method=RequestMethod.GET)
	public void fileDownload(@RequestParam("filename") String fileName,HttpServletResponse response){	
		File directoryLocation = new File("E:"+File.separator+"springBootUploadFiles");			
		try(FileInputStream fis = new FileInputStream(directoryLocation.getAbsolutePath()+File.separator+fileName)) {			
			response.setHeader("Content-Disposition","attachment;filename="+fileName);//getting the popup message to download the file			
			IOUtils.copy(fis, response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			throw new RuntimeException("IO Error Writing file to Output Stream");
		}
	}
}
