package com.ExploreCanada.packages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ExploreCanada.packages.Dao.PackageListDao;
import com.ExploreCanada.packages.entities.PackageDetails;

@Repository
public class PakageListServiceImpl implements PackageListService {
	
	private PackageListDao packageListDao;
	
	@Autowired
	public PakageListServiceImpl(PackageListDao thePackageListDao) {
		packageListDao=thePackageListDao;
	}

	@Override
    @Transactional
	public List<PackageDetails> findAll() {
		return packageListDao.findAll();
	}

}
