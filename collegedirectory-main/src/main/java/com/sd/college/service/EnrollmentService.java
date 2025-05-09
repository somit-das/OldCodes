package com.sd.college.service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

	ResponseEntity<?> findEnrollmentByUserId(int uid);

	ResponseEntity<?> saveEnrollment(int uid, int cid);

	ResponseEntity<?> findAllEnrollmentsByFacultyProfileId(int fid);

}
