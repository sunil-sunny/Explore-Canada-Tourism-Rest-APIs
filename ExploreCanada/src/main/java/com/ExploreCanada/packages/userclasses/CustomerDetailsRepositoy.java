package com.ExploreCanada.packages.userclasses;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExploreCanada.packages.entities.CustomerDetails;

public interface CustomerDetailsRepositoy extends JpaRepository<CustomerDetails, String> {

}
