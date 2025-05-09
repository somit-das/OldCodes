package com.sd.college.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.college.dao.StudentProfileDao;
import com.sd.college.entity.StudentProfile;
import com.sd.college.repository.StudentProfileRepository;


@Service
public class StudentProfileDaoImpl implements StudentProfileDao {

	@Autowired
	private StudentProfileRepository studentProfileRepository;

	@Override
	public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
		return studentProfileRepository.save(studentProfile);
	}

	@Override
	public List<StudentProfile> findAllStudentProfiles() {
		return studentProfileRepository.findAll();
	}

	@Override
	public Optional<StudentProfile> findStudentProfileById(int id) {
		return studentProfileRepository.findById(id);
	}

}
