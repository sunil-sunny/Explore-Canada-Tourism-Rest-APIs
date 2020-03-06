package com.ExploreCanada.packages.Dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ExploreCanada.packages.entities.CustomerDetails;

@Repository
public class RegisterUserDaoImpl implements RegisterUserDao {
	
    private EntityManager entityManager;
	
	@Autowired
	public RegisterUserDaoImpl(EntityManager theEntityManager) {
		
		entityManager=theEntityManager;
	}

	@Override
	public CustomerDetails registerCustomer(CustomerDetails customerDetails) {
		
		Session currenSession=entityManager.unwrap(Session.class);
		
		String result=(String) currenSession.save(customerDetails);
		
		if(result!=null) {
			return customerDetails;
		}
		else {
			return null;
		}

		
	}

}
