package com.ExploreCanada.packages.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.Jwt.JwtRequestFilter;
import com.ExploreCanada.packages.entities.BookDetailsDTO;
import com.ExploreCanada.packages.entities.BookingQueryDetails;
import com.ExploreCanada.packages.entities.CustomerSpecificDetails;
import com.ExploreCanada.packages.service.BookDetailsService;
import com.ExploreCanada.packages.service.CustomerDetailsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BookTravelRestController {
	
	private static String USER_NAME="AC8ea130464bcd9ca52c1e9b13292e6dee";
	private static String PASSWORD="8e522c2461cfc81ba43640e6993930c8";
    static{
		
		Twilio.init(USER_NAME, PASSWORD);
		
	}
	@Autowired
	private BookDetailsService bookingDetailService;
	@Autowired
	private JwtRequestFilter jwtTokenFilter;
	@Autowired
	private CustomerDetailsService customerDetailsService;

	@RequestMapping(value="/book",method=RequestMethod.POST)
	public BookDetailsDTO bookTicket(@RequestBody BookingQueryDetails bookingQueryDetails){
		String username=jwtTokenFilter.getUsername();
		CustomerSpecificDetails customerdetails=customerDetailsService.getCustomerDetails(username);
		BookDetailsDTO bookingDetails=bookingDetailService.bookTicket(bookingQueryDetails,username);
		Message.creator(new PhoneNumber(customerdetails.getMobileNumber()), new PhoneNumber("+12055123837"),
		         "Your Bus booking from "+bookingDetails.getFromPlace()+" to "+bookingDetails.getToPlace()+
		         " is now confirmed.Booking id for your reservation is :"+bookingDetails.getBookingID()).create();
		return bookingDetails;	
	}

}
