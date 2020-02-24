package com.ExploreCanada.packages.service;

import java.util.List;

import com.ExploreCanada.packages.entities.PackageDetails;

public interface PackageListService {

	public List<PackageDetails> findAll();
}
