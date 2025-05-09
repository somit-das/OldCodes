package com.sd.college.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.college.dao.AdministratorProfileDao;
import com.sd.college.entity.AdministratorProfile;
import com.sd.college.repository.AdministratorProfileRepository;


@Repository
public class AdministratorProfileDaoImpl implements AdministratorProfileDao {

	@Autowired
	private AdministratorProfileRepository administratorProfileRepository;
	
	@Override
	public AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorProfile) {
		return administratorProfileRepository.save(administratorProfile);
	}

	@Override
	public Optional<AdministratorProfile> findAdministratorProfileById(int id) {
		return administratorProfileRepository.findById(id);
	}
	
	

}
