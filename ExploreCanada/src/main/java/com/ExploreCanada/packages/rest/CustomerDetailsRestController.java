package com.ExploreCanada.packages.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.entities.CustomerSpecificDetails;
import com.ExploreCanada.packages.service.CustomerDetailsService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerDetailsRestController {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@GetMapping("/userdetails/{userid}")
	public CustomerSpecificDetails findByCity(@PathVariable(value = "userid") String userid){
		
		System.out.println(userid);
		return customerDetailsService.getCustomerDetails(userid);

	}

}
