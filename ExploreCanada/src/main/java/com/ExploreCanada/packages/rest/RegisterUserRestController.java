package com.ExploreCanada.packages.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.entities.CustomerDetailsDTO;
import com.ExploreCanada.packages.service.RegisterUserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class RegisterUserRestController {
	
	@Autowired
	private RegisterUserService registerUserService;
	
	
	@PostMapping(value = "/register")
    public ResponseEntity<Object> registerCustomer(@RequestBody @Valid CustomerDetailsDTO theCustomerDetailsDTO) {
		
		if(registerUserService.registerCustomer(theCustomerDetailsDTO).getUserId().compareToIgnoreCase("")==0) {
			return new ResponseEntity<>("failure",HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
			
	}
	
	@PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> registerCustomerForm(CustomerDetailsDTO theCustomerDetailsDTO) {
		/*
		 * System.out.println(theCustomerDetailsDTO.getDateOfBirth()); return
		 * registerUserService.registerCustomer(theCustomerDetailsDTO);
		 */
		
		if(registerUserService.registerCustomer(theCustomerDetailsDTO).getUserId().compareToIgnoreCase("")==0) {
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
		}
	}

}
