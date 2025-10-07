package com.ashokit.dao;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ashokit_enquires")
public class Enquiry {

	@Id
	@SequenceGenerator(name = "gen", sequenceName = "enquiry_id_seq", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
	private Integer enquiryId;

	@Column(name = "enquiry_name", nullable = false)
	private String enquiryName;

	@Column(name = "email", nullable = false, unique = true)
	private String emailId;

	@Column(name = "contact_no", nullable = false)
	private String contactNo;

	@Column(name = "course", nullable = false)
	private String course;

	@Column(name = "created_dt", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getEnquiryName() {
		return enquiryName;
	}

	public void setEnquiryName(String enquiryName) {
		this.enquiryName = enquiryName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", enquiryName=" + enquiryName + ", emailId=" + emailId
				+ ", contactNo=" + contactNo + ", course=" + course + ", createdDate=" + createdDate + "]";
	}
}
