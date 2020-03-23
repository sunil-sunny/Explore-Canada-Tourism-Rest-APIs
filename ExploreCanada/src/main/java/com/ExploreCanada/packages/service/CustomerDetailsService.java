package com.ExploreCanada.packages.service;

import com.ExploreCanada.packages.entities.CustomerSpecificDetails;

public interface CustomerDetailsService{
	
	public CustomerSpecificDetails getCustomerDetails(String username);
	
}
