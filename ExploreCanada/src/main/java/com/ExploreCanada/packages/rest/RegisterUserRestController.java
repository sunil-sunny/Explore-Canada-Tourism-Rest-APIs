package com.ExploreCanada.packages.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.entities.CustomerDetailsDTO;
import com.ExploreCanada.packages.service.RegisterUserService;

@RestController
@RequestMapping("/api")
public class RegisterUserRestController {
	
	@Autowired
	private RegisterUserService registerUserService;
	
	
	@PostMapping(value = "/register")
    public CustomerDetailsDTO registerCustomer(@RequestBody @Valid CustomerDetailsDTO theCustomerDetailsDTO) {
		
		return registerUserService.registerCustomer(theCustomerDetailsDTO);
		
	}
	
	@PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public CustomerDetailsDTO registerCustomerForm(@Valid CustomerDetailsDTO theCustomerDetailsDTO) {
		
		System.out.println(theCustomerDetailsDTO.getDateOfBirth());
		return registerUserService.registerCustomer(theCustomerDetailsDTO);
		
	}

}
