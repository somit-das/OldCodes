package com.sd.college.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sd.college.dao.CourseDao;
import com.sd.college.dao.FacultyProfileDao;
import com.sd.college.entity.Course;
import com.sd.college.entity.FacultyProfile;
import com.sd.college.responsestructure.ResponseStructure;
import com.sd.college.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private FacultyProfileDao facultyProfileDao;
	
	
	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		
		course = courseDao.saveCourse(course);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course Created Successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> courses = courseDao.findAllCourses();
		if(courses.isEmpty())
			throw new RuntimeException("No Courses Present In Database Table...");
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Courses Found Successfully...").body(courses).build());
	}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
		Optional<Course> optional = courseDao.findCourseById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Ivalid Course Id : "+id);
		Course course = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course Found Successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {
		Optional<Course> optional = courseDao.findCourseById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Ivalid Course Id : "+id);
		courseDao.deleteCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course Deleted Successfully...").body("Course Deleted Successfully...").build());
	}

	@Override
	public ResponseEntity<?> assignFacultyToCourse(int id, int fid) {
		Optional<FacultyProfile> optional1 = facultyProfileDao.findFacultyProfileById(fid);
		if(optional1.isEmpty())
			throw new RuntimeException("Ivalid Faculty Id : "+fid);
		Optional<Course> optional2 = courseDao.findCourseById(id);
		if(optional2.isEmpty())
			throw new RuntimeException("Ivalid Course Id : "+id);
		FacultyProfile facultyProfile = optional1.get();
		Course course = optional2.get();
		course.setFaculty(facultyProfile);
		course =  courseDao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Faculty Assigned To Course Successfully...").body(course).build());
	}

}
