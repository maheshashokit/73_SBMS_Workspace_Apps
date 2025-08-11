package com.ashokit.spring.beans;

public class Course {

	private String courseName;

	private Integer courseFee;

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseFee(Integer courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseName() {
		return courseName;
	}

	public Integer getCourseFee() {
		return courseFee;
	}

	@Override
	public String toString() {
		return String.format("CourseName %s and CourseFee %s ", courseName, courseFee);
	}
}
