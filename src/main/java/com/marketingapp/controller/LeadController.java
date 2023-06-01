package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.Dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.service.LeadService;
import com.marketingapp.utility.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService; // object creation of leadservice interface here we are using class upcastion of
										// leadserviceImpl

	@Autowired
	private EmailService emailService;
	//http://localhost:8080/create 				//it will call viewCreateLead
	@RequestMapping("/create") // works as webServlet
	public String viewCreateLead() {
		return "create_lead"; // it will work as requestDispactcher
	}

//3 ways to take the data from form
	@RequestMapping("/saveLead") // creat_lead give the data here
	public String saveLead(@ModelAttribute Lead lead, ModelMap model) { // (entity class, entity object) create_lead
																		// data goes to the object lead, @modelAttribute
																		// copy the data into entity object
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "Test", "Welcome"); 		// it will send the data to mail who will fill the registration form
		model.addAttribute("msg", "Record is saved!!"); // work as set.Attribute
		return "create_lead"; // come to this page

	}
//	@RequestMapping("/saveLead")  // this method is very lengthy for each coloum only use it for sort forms
//	public String saveLead(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile
//			) {
//		Lead lead = new Lead(); //intializing entity class object  to call all the data with it
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		leadService.saveLead(lead);
//		return "create_lead";
//	}
//	@RequestMapping("/saveLead")
//	public String saveLead(LeadDto leadDto) {  //taking data with ordinary class not with entity class
////		System.out.println(leadDto.getFirstName());  //taking the data on system
////		System.out.println(leadDto.getLastName());
////		System.out.println(leadDto.getEmail());
////		System.out.println(leadDto.getMobile());
//		
//		Lead lead = new Lead(); // creating Lead entity object bcoz only entity data goes to database
//		lead.setFirstName(leadDto.getFirstName());
//		lead.setLastName(leadDto.getLastName());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
//		leadService.saveLead(lead);  //saving the data
//		
//		
//		return "create_lead";
//		
//	}

	// http://localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads(); // collection
		model.addAttribute("leads", leads);
		return "search_result";
	}
	

	
	//Deleting the lead based on Email
	
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("email") String email, Model model) {
		leadService.deleteLeadByEmail(email);
		List<Lead> leads = leadService.getAllLeads(); // collection
		model.addAttribute("leads", leads);
		return "search_result";
	}
	
	@RequestMapping("/update")
	public String getLeadByEmail(@RequestParam("email") String email, Model model) {
		Lead lead = leadService.findLeadByEmail(email);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto, Model model) {
		Lead l = new Lead();
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		
		leadService.saveLead(l);
		
		
		List<Lead> leads = leadService.getAllLeads(); // collection
		model.addAttribute("leads", leads);
		return "search_result";
	}

}
