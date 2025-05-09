package com.sd.college.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.college.dao.FacultyProfileDao;
import com.sd.college.entity.FacultyProfile;
import com.sd.college.repository.FacultyProfileRepository;


@Repository
public class FacultyProfileDaoImpl implements FacultyProfileDao{

	@Autowired
	private FacultyProfileRepository facultyProfileRepository ;
	
	
	@Override
	public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
		return facultyProfileRepository.save(facultyProfile);
	}


	@Override
	public List<FacultyProfile> findAllFacultyProfile() {
		return facultyProfileRepository.findAll();
	}


	@Override
	public Optional<FacultyProfile> findFacultyProfileById(int id) {
		return facultyProfileRepository.findById(id);
	}

	
	
	
	
}
