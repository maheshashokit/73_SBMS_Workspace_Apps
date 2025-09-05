package com.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name = "mahesh_bikes")
public class Bike {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE) //hibernate_seqences(seq_name, seq_value) -> (default, 1)
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "bikes")
	@TableGenerator(name ="bikes",
	                table = "sequence_store",
	                pkColumnName = "seq_name",
	                valueColumnName = "seq_value",
	                pkColumnValue = "bike_id",
	                initialValue = 1,
	                allocationSize = 1)
	private int bikeId;
	
	private String bikeName;
	
	private Integer cost;

	public Integer getBikeId() {
		return bikeId;
	}

	public void setBikeId(Integer bikeId) {
		this.bikeId = bikeId;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", bikeName=" + bikeName + ", cost=" + cost + "]";
	}

}
