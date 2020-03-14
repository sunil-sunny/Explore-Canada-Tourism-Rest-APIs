package com.ExploreCanada.packages.userclasses;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExploreCanada.packages.entities.PackageDetails;

public interface PackagesRepository extends JpaRepository<PackageDetails, Integer> {
	

}
