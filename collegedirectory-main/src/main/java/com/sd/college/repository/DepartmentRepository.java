package com.sd.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.college.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
}
