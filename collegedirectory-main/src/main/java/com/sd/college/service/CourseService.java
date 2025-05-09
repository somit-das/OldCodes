package com.sd.college.service;

import org.springframework.http.ResponseEntity;

import com.sd.college.entity.Course;


public interface CourseService {

	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findAllCourses();

	ResponseEntity<?> findCourseById(int id);

	ResponseEntity<?> deleteCourseById(int id);

	ResponseEntity<?> assignFacultyToCourse(int id, int fid);

}
