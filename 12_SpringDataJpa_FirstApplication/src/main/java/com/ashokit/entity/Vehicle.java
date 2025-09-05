package com.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "mahesh_vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
	@SequenceGenerator(name = "vehicle_seq", 
	                   sequenceName = "mahesh_vehicles_seq", 
	                   initialValue = 1,
	                   allocationSize = 1)
	private Integer vehicleId;

	private String vehicleName;

	private float vehicleCost;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public float getVehicleCost() {
		return vehicleCost;
	}

	public void setVehicleCost(float vehicleCost) {
		this.vehicleCost = vehicleCost;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleCost=" + vehicleCost
				+ "]";
	}

}
