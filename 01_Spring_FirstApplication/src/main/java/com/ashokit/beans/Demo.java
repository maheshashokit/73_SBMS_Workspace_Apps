package com.ashokit.beans;

public class Demo {
	// Defining the Property
	private String topicName;

	// Defining the Constructor
	public Demo() {
		System.out.println("Spring Bean Demo Class....");
	}

	// Defining the Constructor to inject the value for topicName
	public Demo(String topicName) {
		this.topicName = topicName;
	}

	public void showData() {
		System.out.println("TopicName =" + topicName);
	}
	
	@Override
	public String toString() {
		return "Demo [topicName=" + topicName + "]";
	}
}
