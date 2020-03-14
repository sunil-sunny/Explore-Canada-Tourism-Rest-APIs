package com.ExploreCanada.packages.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.Jwt.JwtRequestFilter;
import com.ExploreCanada.packages.entities.BookDetailsDTO;
import com.ExploreCanada.packages.entities.BookingQueryDetails;
import com.ExploreCanada.packages.service.BookDetailsService;

@RestController
public class BookTravelRestController {
	

	@Autowired
	private BookDetailsService bookingDetailService;
	@Autowired
	private JwtRequestFilter jwtTokenFilter;

	@RequestMapping(value="/book",method=RequestMethod.POST)
	public BookDetailsDTO bookTicket(@RequestBody BookingQueryDetails bookingQueryDetails){
		String username=jwtTokenFilter.getUsername();
		return bookingDetailService.bookTicket(bookingQueryDetails,username);	
	}

}
