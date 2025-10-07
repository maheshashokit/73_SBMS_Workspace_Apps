package com.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "ashokit_customers")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="fetchCustomerName",
                               procedureName="GET_CUSTOMER_NAME_BY_ID",
                               parameters = {
                            		   @StoredProcedureParameter(name="custId",mode = ParameterMode.IN,type = Integer.class),
                            		   @StoredProcedureParameter(name="custName",mode = ParameterMode.OUT,type=String.class)
                               }),
	@NamedStoredProcedureQuery(name = "customerInfoDetails", 
	                           procedureName ="GET_CUSTOMER_INFO", 
	                           parameters = {
							            @StoredProcedureParameter(mode = ParameterMode.IN, name = "custId", type = Integer.class),
							            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "custName", type = String.class),
							            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "custLocation", type = String.class)
							  }),
	@NamedStoredProcedureQuery(name="fetchCustomerDetails",
							   procedureName="GET_CUSTOMER_BY_ID",
							   resultClasses = Customer.class,
							   parameters = {
									@StoredProcedureParameter(mode = ParameterMode.IN,name = "custId",type = Integer.class),   
							 	    @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR,name = "Details",type=void.class)	   
							   }),
	@NamedStoredProcedureQuery(name="fetchAllCustomerDetails",
							   procedureName="GET_ALL_CUSTOMERS",
							   resultClasses = Customer.class,
							   parameters = {
							 	  @StoredProcedureParameter(name="Details",type=void.class,mode=ParameterMode.REF_CURSOR)	   
							   })

})
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO) //ORM will use hibernate_sequence
	private Integer customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "location")
	private String customerLocation;
	
	@Column(name="bill_amount")
	private Integer billAmount;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}
	
	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}
	
	public Integer getBillAmount() {
		return billAmount;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerLocation="
				+ customerLocation + ", billAmount=" + billAmount + "]";
	}
}
