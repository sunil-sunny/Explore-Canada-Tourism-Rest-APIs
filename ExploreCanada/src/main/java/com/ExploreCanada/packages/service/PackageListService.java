package com.ExploreCanada.packages.service;

import java.util.List;

import com.ExploreCanada.packages.entities.PackageDetailsDTO;

public interface PackageListService {

	public List<PackageDetailsDTO> findAll();
}
