package com.ashokit.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entites.Enquiry;

public interface EnquiryDao extends JpaRepository<Enquiry,Serializable> {

}
