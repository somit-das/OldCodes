package com.sd.college.dao;

import java.util.List;
import java.util.Optional;

import com.sd.college.entity.StudentProfile;


public interface StudentProfileDao {

	StudentProfile saveStudentProfile(StudentProfile studentProfile);

	List<StudentProfile> findAllStudentProfiles();

	Optional<StudentProfile> findStudentProfileById(int id);

}
