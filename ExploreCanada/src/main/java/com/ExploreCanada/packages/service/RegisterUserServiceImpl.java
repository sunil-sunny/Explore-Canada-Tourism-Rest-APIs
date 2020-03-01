package com.ExploreCanada.packages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ExploreCanada.packages.Dao.RegisterUserDao;
import com.ExploreCanada.packages.entities.CustomerDetails;
import com.ExploreCanada.packages.entities.CustomerDetailsDTO;

@Repository
public class RegisterUserServiceImpl implements RegisterUserService {
	
	private RegisterUserDao registerUserDao;
	
	@Autowired
	public RegisterUserServiceImpl(RegisterUserDao theRegisterUserDao) {
		
		registerUserDao=theRegisterUserDao;
	}

	@Override
	@Transactional
	public CustomerDetailsDTO registerCustomer(CustomerDetailsDTO customerDetailsDTO) {
		
		CustomerDetails customerDetails=new CustomerDetails(customerDetailsDTO);
		String hashedPassword=BCrypt.hashpw(customerDetails.getPassword(), BCrypt.gensalt(10));
		customerDetails.setPassword(hashedPassword);	
		CustomerDetails abc=registerUserDao.registerCustomer(customerDetails);
		if(abc!=null) {
			return new CustomerDetailsDTO(abc);
		}
		else {
			return null;
		}
		
	}

}
