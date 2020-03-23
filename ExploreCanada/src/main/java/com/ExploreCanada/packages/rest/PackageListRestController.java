package com.ExploreCanada.packages.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ExploreCanada.packages.Jwt.JwtRequestFilter;
import com.ExploreCanada.packages.entities.PackageDetailsDTO;
import com.ExploreCanada.packages.service.PackageListService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class PackageListRestController {
	
	private PackageListService packageListService;
	

	@Autowired
	private JwtRequestFilter jwtTokenFilter;
	
	@Autowired
	public PackageListRestController(PackageListService thePackageListService) {
		
		
		packageListService=thePackageListService;
		/* jwtTokenUtil=utilToken; */
		
		
	}
	
	@GetMapping("/packagelist")
	public Map<String,List<PackageDetailsDTO>> findAll(){
		
		Map<String,List<PackageDetailsDTO>> output=new HashMap<String, List<PackageDetailsDTO>>();
		output.put("packagelist", packageListService.findAll());
		
		return output;
	}
	
	@GetMapping("/packagelist/{city}")
	public List<PackageDetailsDTO> findByCity(@PathParam(value = "city") String city){
		
		System.out.println("here================================");
		System.out.println(city);
		return packageListService.findByCity(city);

	}

}
