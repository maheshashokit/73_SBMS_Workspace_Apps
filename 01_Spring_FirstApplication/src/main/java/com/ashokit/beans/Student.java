package com.ashokit.beans;

public class Student {

	private String studentId;
	private String name;
	private String city;
	private String emailId;
	//looking some of services from course
	private Course course;
	
	public Student() {
		System.out.println("Student class Default Constructor....");
	}
	
	public Student(Course course) {
		System.out.println("Inside the constructor.....");
		this.course = course;
	}
	
	//Injecting values for above properties using setter injection
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setCourse(Course course) {
		System.out.println("Setter method.....");
		this.course = course;
	}
	
	public void displayStudentDetails() {
		System.out.println("Student ID      ::::" + studentId);
		System.out.println("Student Name    :::" + name);
		System.out.println("Student City    ::::" + city);
		System.out.println("Student EmailID ::::" + emailId);
		//course object service method calling
		course.displayCourseDetails();		
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", city=" + city + ", emailId=" + emailId
				+ ", course=" + course + "]";
	}
	
}
