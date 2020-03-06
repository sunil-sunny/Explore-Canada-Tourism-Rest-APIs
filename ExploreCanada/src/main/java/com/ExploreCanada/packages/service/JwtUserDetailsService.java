package com.ExploreCanada.packages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ExploreCanada.packages.entities.CustomerDetails;
import com.ExploreCanada.packages.userclasses.UserDetailsImpl;
import com.ExploreCanada.packages.userclasses.UserRepository;


@Service("userDetailsService")
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		CustomerDetails customerDetails=userRepository.findByUsername(username);
		
		if(customerDetails==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserDetailsImpl(customerDetails);
	}

}
