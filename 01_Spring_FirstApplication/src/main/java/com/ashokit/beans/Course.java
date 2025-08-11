package com.ashokit.beans;

public class Course {
	
	private String courseId;
	private String name;
	private int courseFee;
	
	//Injecting values for above properties using setter injection
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	
	public void displayCourseDetails(){
		System.out.println("Course Id      ::::" + courseId);
		System.out.println("Course Name    ::::" + name);
		System.out.println("Course Fee     ::::" + courseFee);
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", courseFee=" + courseFee + "]";
	}
}