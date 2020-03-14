package com.ExploreCanada.packages.service;

import com.ExploreCanada.packages.entities.BookDetailsDTO;
import com.ExploreCanada.packages.entities.BookingQueryDetails;

public interface BookDetailsService {
	
	public BookDetailsDTO bookTicket(BookingQueryDetails bookingQueryDetails,String username);

}
