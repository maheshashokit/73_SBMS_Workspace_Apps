package com.ashokit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Person;

public interface PersonDao extends JpaRepository<Person, Integer> {

}