package com.ExploreCanada.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExploreCanada.packages.Dao.CustomerDetailsDao;
import com.ExploreCanada.packages.entities.BookingDetails;
import com.ExploreCanada.packages.entities.CustomerDetailsDTO;
import com.ExploreCanada.packages.entities.CustomerSpecificDetails;
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
	
	@Autowired
	private CustomerDetailsDao customerDetailsDao;

	@Override
	public CustomerSpecificDetails getCustomerDetails(String username) {
		CustomerDetailsDTO customer=new CustomerDetailsDTO(customerDetailsDao.getCustomerDetails(username));
		List<BookingDetails> booklist=customerDetailsDao.getBookingDetails(username);
		CustomerSpecificDetails customerDetails=new CustomerSpecificDetails(customer, booklist);
		return customerDetails;
	}


}
