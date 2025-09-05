package com.ashokit.dao;

import org.springframework.data.repository.CrudRepository;

import com.ashokit.entity.Bike;

public interface BikeDao extends CrudRepository<Bike, Integer> {

}
