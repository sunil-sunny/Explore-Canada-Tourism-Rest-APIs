package com.ExploreCanada.packages.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.entities.CustomerDetails;
import com.ExploreCanada.packages.userclasses.BookingDetailsRepository;
import com.ExploreCanada.packages.userclasses.CustomerDetailsRepositoy;

@Repository
public class CustomerDetailsDaoImpl implements CustomerDetailsDao {

	@Autowired
	private CustomerDetailsRepositoy customerDetailsRepositoy;
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	@Override
	public CustomerDetails getCustomerDetails(String username) {	
		 Optional<CustomerDetails>
		 presentCustomer=customerDetailsRepositoy.findById(username);
		 return presentCustomer.get();		
		
	}
	@Override
	public List<BookingDetails> getBookingDetails(String username) {
		
		List<BookingDetails> bookinglist=bookingDetailsRepository.findAll();
		System.out.println("username is:"+username);
		System.out.println("Booking list for s is: "+bookinglist.size());
		List<BookingDetails> userbookingdetails=new ArrayList<BookingDetails>();
		for(BookingDetails booking:bookinglist) {
			
			System.out.println(booking);
			
			if(booking.getCustomerID().equalsIgnoreCase(username)) {
				userbookingdetails.add(booking);		
			}
			
		}
		return userbookingdetails;
	}

}
