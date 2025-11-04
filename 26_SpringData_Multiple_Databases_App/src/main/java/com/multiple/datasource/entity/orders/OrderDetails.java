package com.multiple.datasource.entity.orders;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS") //OracleDatabase
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String quantity;

	private String price;

	@CreationTimestamp
	private Date created;

	@UpdateTimestamp
	private Date updated;

	public OrderDetails() {

	}

	public OrderDetails(long id, String quantity, String price, Date created, Date updated) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.created = created;
		this.updated = updated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + ", price=" + price + ", created=" + created
				+ ", updated=" + updated + "]";
	}

}
