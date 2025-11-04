package com.multiple.datasource.entity.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYMENT_DETAILS")  //MySql Database
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cardNumber;
	private String cardName;
	private String expiry;
	private String cvv;

	public PaymentDetails() {

	}

	public PaymentDetails(long id, String cardNumber, String cardName, String expiry, String cvv) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.expiry = expiry;
		this.cvv = cvv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", cardNumber=" + cardNumber + ", cardName=" + cardName + ", expiry="
				+ expiry + ", cvv=" + cvv + "]";
	}

}
