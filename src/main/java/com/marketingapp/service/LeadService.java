package com.marketingapp.service;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {

	
	public void saveLead(Lead lead);
	public List<Lead> getAllLeads(); //collection used
	
	
	
	public void deleteLeadByEmail(String email);
	public Lead findLeadByEmail(String email);
}
