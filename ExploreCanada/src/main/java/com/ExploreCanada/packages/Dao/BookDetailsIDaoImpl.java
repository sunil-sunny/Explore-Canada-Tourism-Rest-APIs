package com.ExploreCanada.packages.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.userclasses.BookingDetailsRepository;

@Repository
public class BookDetailsIDaoImpl implements BookDetailsDao {	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	@Override
	public boolean bookTicket(BookingDetails bookingDetails) {
		bookingDetailsRepository.save(bookingDetails);
		boolean isInserted=bookingDetailsRepository.existsById(bookingDetails.getBookingID());
	return isInserted;
	}

}
