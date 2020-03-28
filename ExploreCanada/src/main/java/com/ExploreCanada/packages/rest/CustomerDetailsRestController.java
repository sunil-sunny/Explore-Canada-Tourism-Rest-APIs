package com.ExploreCanada.packages.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.Jwt.JwtRequestFilter;
import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.entities.CustomerSpecificDetails;
import com.ExploreCanada.packages.service.CustomerDetailsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CustomerDetailsRestController {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	@Autowired
	private JwtRequestFilter jwtTokenFilter;
	
	@GetMapping("/userdetails")
	public CustomerSpecificDetails findCustomerDetails(){
		
		String userid=jwtTokenFilter.getUsername();
		System.out.println(userid);
		return customerDetailsService.getCustomerDetails(userid);

	}
	@GetMapping("/bookingdetails")
	public List<BookingDetails> findBookingDetails() {
		
		String userid=jwtTokenFilter.getUsername();
		System.out.println(userid);
		return customerDetailsService.getCustomerBooking(userid);
		
		
	}
		
}
