package com.sd.college.service;

import org.springframework.http.ResponseEntity;

import com.sd.college.entity.Department;


public interface DepartmentService {

	ResponseEntity<?> saveDepartment(Department department);

	ResponseEntity<?> findAllDepartments();

	ResponseEntity<?> findDepartmentById(int id);

	ResponseEntity<?> deleteDepartmentById(int id);

}
