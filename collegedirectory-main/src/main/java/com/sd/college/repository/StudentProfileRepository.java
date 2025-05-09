package com.sd.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.college.entity.StudentProfile;


public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer>{

}
