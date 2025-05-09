package com.sd.college.service;

import org.springframework.http.ResponseEntity;

import com.sd.college.entity.AdministratorProfile;


public interface AdministratorProfileService {
	
	ResponseEntity<?> saveAdministratorProfile(AdministratorProfile administratorProfile);
	
	ResponseEntity<?> findAdministratorProfileById(int id);
	
}
