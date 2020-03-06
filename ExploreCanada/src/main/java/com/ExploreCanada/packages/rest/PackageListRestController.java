package com.ExploreCanada.packages.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExploreCanada.packages.entities.PackageDetailsDTO;
import com.ExploreCanada.packages.service.PackageListService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class PackageListRestController {
	
	private PackageListService packageListService;
	
	@Autowired
	public PackageListRestController(PackageListService thePackageListService) {
		
		packageListService=thePackageListService;
		
	}
	
	@GetMapping("/packagelist")
	public List<PackageDetailsDTO> findAll(){
		return packageListService.findAll();
	}

}
