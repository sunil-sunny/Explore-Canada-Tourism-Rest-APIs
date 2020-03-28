package com.ExploreCanada.packages.service;

import java.util.List;

import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.entities.CustomerSpecificDetails;

public interface CustomerDetailsService{
	
	public CustomerSpecificDetails getCustomerDetails(String username);

	public List<BookingDetails> getCustomerBooking(String username);
	
}
