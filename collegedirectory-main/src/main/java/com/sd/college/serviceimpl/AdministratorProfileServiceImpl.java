package com.sd.college.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sd.college.dao.AdministratorProfileDao;
import com.sd.college.entity.AdministratorProfile;
import com.sd.college.responsestructure.ResponseStructure;
import com.sd.college.service.AdministratorProfileService;

@Service
public class AdministratorProfileServiceImpl implements AdministratorProfileService{

	@Autowired
	private AdministratorProfileDao administratorProfileDao;
	
	
	@Override
	public ResponseEntity<?> saveAdministratorProfile(AdministratorProfile administratorProfile) {
		return null;
	}

	@Override
	public ResponseEntity<?> findAdministratorProfileById(int id) {
		Optional<AdministratorProfile> optinal = administratorProfileDao.findAdministratorProfileById(id);
//		if(optinal.isEmpty())
//			throw Exception();
		AdministratorProfile administratorProfile = optinal.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Administrator Found Successfully...").body(administratorProfile).build());
	}

}
