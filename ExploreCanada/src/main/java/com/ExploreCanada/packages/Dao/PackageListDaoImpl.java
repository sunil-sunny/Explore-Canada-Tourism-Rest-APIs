package com.ExploreCanada.packages.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExploreCanada.packages.entities.PackageDetails;
import com.ExploreCanada.packages.userclasses.PackagesRepository;

@Repository
public class PackageListDaoImpl implements PackageListDao {
	
	private EntityManager entityManager;
	@Autowired
	private PackagesRepository packageRepository;
	
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

	@Override
	public List<PackageDetails> findByCity(String cityName) {

		List<PackageDetails> packages=packageRepository.findAll();
		List<PackageDetails> cityPackages=new ArrayList<PackageDetails>();
		
		for(PackageDetails p:packages) {
			
			System.out.println(p.getDestination());
			
			if(p.getDestination().equalsIgnoreCase(cityName)) {
				cityPackages.add(p);
			}
			
		}
		return cityPackages;
	}

}
