package com.sd.college.dao;

import java.util.List;
import java.util.Optional;

import com.sd.college.entity.Course;

public interface CourseDao {

	Course saveCourse(Course course);

	List<Course> findAllCourses();

	Optional<Course> findCourseById(int id);

	void deleteCourseById(int id);

}
