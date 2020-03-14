package com.ExploreCanada.packages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExploreCanada.packages.Dao.BookDetailsDao;
import com.ExploreCanada.packages.entities.BookDetailsDTO;
import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.entities.BookingQueryDetails;

@Repository
public class BookDetailsServiceImpl implements BookDetailsService {
	
	@Autowired
	private BookDetailsDao bookDetailsDao;
	

	@Override
	public BookDetailsDTO bookTicket(BookingQueryDetails bookingQueryDetails,String username) {
	
		BookDetailsDTO bookedTicket=new BookDetailsDTO();
		String booking=String.valueOf((int)((Math.random())*(10000-1000))+9999);
		bookedTicket.setBookingID(booking);
		bookedTicket.setCustomerID(username);
		bookedTicket.setFromPlace(bookingQueryDetails.getFromDetails());
		bookedTicket.setToPlace(bookingQueryDetails.getToDetails());
		bookedTicket.setJourneyDate(bookingQueryDetails.getJourneyDate());
		BookingDetails bookDetails=new BookingDetails(bookedTicket);
		boolean booked=bookDetailsDao.bookTicket(bookDetails);
		System.out.println(booked);
		return bookedTicket;
	}
	

}
