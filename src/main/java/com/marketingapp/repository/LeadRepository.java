package com.marketingapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.entities.Lead;

public interface LeadRepository extends  JpaRepository<Lead, Long> {
	
	@Transactional
	void deleteByEmail(String email);

	Lead findByEmail(String email);

}
