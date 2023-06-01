package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.Dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@RestController    //it will work as api
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	//http://localhost:8080/api/leads
	
	@GetMapping				//will take data from db and put it into JSON object and will display it in browser
	public List<Lead> getAllLeads(){		//retriving the data from database
		
		List<Lead> leads = leadRepo.findAll();			// working as JSON object
		return leads;
		
	}
	
	@PostMapping							//Creating the record
	public void createLead(@RequestBody Lead lead) {   //@RequestBody takes the content from JSON and give it to Lead (java)object
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads/1
	@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id") long id) { //@PathVariable reads the value from URL and than we delete the record
		leadRepo.deleteById(id);
	}
	
	//http://localhost:8080/api/leads/1
	@PutMapping("/{id}")
	public void updateLead(@RequestBody LeadDto dto, @PathVariable("id") long id ) {
		Lead l = new Lead();
		l.setId(id);
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		leadRepo.save(l);
		
	}
	
}
