package com.sd.college.dao;

import java.util.List;
import java.util.Optional;

import com.sd.college.entity.FacultyProfile;



public interface FacultyProfileDao {

	FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile);
	
	List<FacultyProfile> findAllFacultyProfile();

	Optional<FacultyProfile> findFacultyProfileById(int id);

}
