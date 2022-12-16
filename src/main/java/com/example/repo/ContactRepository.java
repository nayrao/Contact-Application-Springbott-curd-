package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	public List<Contact> findByActiveSW(String status);

}
