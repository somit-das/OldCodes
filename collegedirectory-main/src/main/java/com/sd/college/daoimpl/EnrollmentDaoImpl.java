package com.sd.college.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.college.dao.EnrollmentDao;
import com.sd.college.entity.Enrollment;
import com.sd.college.repository.EnrollmentRepository;



@Repository
public class EnrollmentDaoImpl implements EnrollmentDao {

	@Autowired
	private EnrollmentRepository repository;

	@Override
	public Enrollment saveEnrollment(Enrollment enrollment) {
		return repository.save(enrollment);
	}

	@Override
	public List<Enrollment> findEnrollmentByUserId(int uid) {
		return repository.findEnrollmentByUserId(uid);
	}

	@Override
	public List<Enrollment> findAllEnrollmentsByFacultyProfileId(int fid) {
		return repository.findAllEnrollmentsByFacultyProfileId(fid);
	}

}
