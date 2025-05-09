package com.sd.college.dao;

import java.util.List;
import java.util.Optional;

import com.sd.college.entity.Department;


public interface DepartmentDao {

	Department saveDepartment(Department department);

	List<Department> findAllDepartments();

	Optional<Department> findDepartmentById(int id);

	void deleteDepartmentById(int id);

}
