package com.sd.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.college.entity.AdministratorProfile;
import com.sd.college.service.AdministratorProfileService;


//@CrossOrigin
@RestController
@RequestMapping(value = "/administratorprofiles")
public class AdministratorProfileController {

	@Autowired
	private AdministratorProfileService administratorProfileService;

	@PostMapping
	public ResponseEntity<?> saveAdministratorProfile(@RequestBody AdministratorProfile administratorProfile) {
		return administratorProfileService.saveAdministratorProfile(administratorProfile);
	}
	
	

}
