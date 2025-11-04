package com.ashokit.binding;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement //Representing the customer as root element of xml content
@XmlAccessorType(XmlAccessType.FIELD)//performing the marshalling process at field level
@XmlType(propOrder = {"custName","custLocation","custId","order"})//changing order to elements while doing marshalling
public class Customer {

	@XmlElement(name="customerId")
	private Integer custId;

	@XmlElement(name="customerName")
	private String custName;

	@XmlElement(name="customerLocation")
	private String custLocation;
	
	@XmlElementWrapper(name="orders")
	private List<Order> order;

	public Customer() {
		System.out.println("Customer Class Constructor");
	}

	public Customer(Integer custId, String custName, String custLocation) {
		this.custId = custId;
		this.custName = custName;
		this.custLocation = custLocation;
	}
	
	public Customer(Integer custId, String custName, String custLocation,List<Order> order) {
		this.custId = custId;
		this.custName = custName;
		this.custLocation = custLocation;
	 	this.order = order;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}
	
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public List<Order> getOrder() {
		return order;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custLocation=" + custLocation + ", order="
				+ order + "]";
	}	
}