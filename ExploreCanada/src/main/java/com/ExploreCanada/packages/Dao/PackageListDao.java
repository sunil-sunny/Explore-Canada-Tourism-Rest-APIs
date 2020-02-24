package com.ExploreCanada.packages.Dao;

import java.util.List;

import com.ExploreCanada.packages.entities.PackageDetails;

public interface PackageListDao {
	
	public List<PackageDetails> findAll();

}
