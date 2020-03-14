package com.ExploreCanada.packages.userclasses;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExploreCanada.packages.entities.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, String> {
	
	

}
