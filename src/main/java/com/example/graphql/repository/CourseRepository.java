package com.example.graphql.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.graphql.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	Optional<Course> findByCourseName(String courseName);
	Optional<Course> findByCourseNumber(String courseNumber);
	Optional<Course> findBySemesterOffered(String semesterOffered);
	
	
}
