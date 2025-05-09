package com.sd.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.college.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

}
