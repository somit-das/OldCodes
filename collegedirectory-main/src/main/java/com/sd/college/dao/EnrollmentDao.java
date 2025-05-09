package com.sd.college.dao;

import java.util.List;

import com.sd.college.entity.Enrollment;


public interface EnrollmentDao {

	List<Enrollment> findEnrollmentByUserId(int uid);

	Enrollment saveEnrollment(Enrollment enrollment);

	List<Enrollment> findAllEnrollmentsByFacultyProfileId(int fid);

}
