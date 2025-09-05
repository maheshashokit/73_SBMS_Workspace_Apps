package com.ashokit.dao;

import org.springframework.data.repository.CrudRepository;

import com.ashokit.entity.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Integer> {

}
