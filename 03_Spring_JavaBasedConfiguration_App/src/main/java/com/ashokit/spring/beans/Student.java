package com.ashokit.spring.beans;

public class Student {

	// simple properties
	private String id;

	private String name;

	private String emailId;

	// Object
	private Course course;

	// setter injection
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("StudentId %s and StudentName %s and EmailId %s and CourseName %s", id, name, emailId,
				course.getCourseName());
	}
}
