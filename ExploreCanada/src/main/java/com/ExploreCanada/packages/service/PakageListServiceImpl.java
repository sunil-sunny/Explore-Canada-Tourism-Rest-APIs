package com.ExploreCanada.packages.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ExploreCanada.packages.Dao.PackageListDao;
import com.ExploreCanada.packages.entities.PackageDetails;
import com.ExploreCanada.packages.entities.PackageDetailsDTO;

@Repository
public class PakageListServiceImpl implements PackageListService {
	
	private PackageListDao packageListDao;
	
	@Autowired
	public PakageListServiceImpl(PackageListDao thePackageListDao) {
		packageListDao=thePackageListDao;
	}

	@Override
    @Transactional
	public List<PackageDetailsDTO> findAll() {
		
		List<PackageDetailsDTO> packageListDto=new ArrayList<PackageDetailsDTO>();
		List<PackageDetails> packageList=packageListDao.findAll();
		PackageDetailsDTO p=null;
		for(PackageDetails packageDetails:packageList) {
			
			p=new PackageDetailsDTO(packageDetails);
			packageListDto.add(p);
			
		}
		
		return packageListDto;
	}

}
