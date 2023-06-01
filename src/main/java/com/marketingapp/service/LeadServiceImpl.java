package com.marketingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@Service   //when we apply @service here than the @autowired work on controller layer for leadservice
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;  //Dependency injection
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll(); //take all the data from DB
		return leads;
	}

	

	

	@Override
	public void deleteLeadByEmail(String email) {
		leadRepo.deleteByEmail(email);
		
	}

	@Override
	public Lead findLeadByEmail(String email) {
		Lead findByEmail = leadRepo.findByEmail(email);
		return findByEmail;
	}

}
