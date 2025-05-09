package com.sd.college.dao;

import java.util.Optional;

import com.sd.college.entity.AdministratorProfile;


public interface AdministratorProfileDao {
	
	
	AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorProfile);
	
	Optional<AdministratorProfile> findAdministratorProfileById(int id);
	
}
