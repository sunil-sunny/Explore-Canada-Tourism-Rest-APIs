package com.ExploreCanada.packages.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ExploreCanada.packages.entities.PackageDetails;

@Repository
public class PackageListDaoImpl implements PackageListDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public PackageListDaoImpl(EntityManager theEntityManager) {
		
		entityManager=theEntityManager;
	}

	@Override
	public List<PackageDetails> findAll() {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<PackageDetails> listOfPackages=currentSession.createQuery("from PackageDetails",
				                                    PackageDetails.class);
		List<PackageDetails> packageList=listOfPackages.getResultList();
		return packageList;
	}

}
