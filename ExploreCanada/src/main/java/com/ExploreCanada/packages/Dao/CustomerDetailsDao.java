package com.ExploreCanada.packages.Dao;

import java.util.List;

import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.entities.CustomerDetails;

public interface CustomerDetailsDao {
	
	public CustomerDetails getCustomerDetails(String username);
	public List<BookingDetails> getBookingDetails(String username);

}
