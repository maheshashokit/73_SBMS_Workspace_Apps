package com.ashokit.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserDto {
	
	private String firstName;
	private String lastName;
	private String qualification;
    private MultipartFile profilePic;
    
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
    public String getFirstName() {
		return firstName;
	}
    
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    public String getLastName() {
		return lastName;
	}
    
    public void setQualification(String qualification) {
		this.qualification = qualification;
	}
    
    public String getQualification() {
		return qualification;
	}
    
    public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}
    
    public MultipartFile getProfilePic() {
		return profilePic;
	}    
}
