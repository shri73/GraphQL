package com.example.graphql.resolver;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.exception.CourseNotFoundException;
import com.example.graphql.exception.StudentNotFoundException;
import com.example.graphql.model.Course;
import com.example.graphql.model.Student;
import com.example.graphql.repository.CourseRepository;
import com.example.graphql.repository.StudentRepository;


@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Course findByCourseName(String courseName) {
		Optional<Course> courseOptional = StreamSupport.stream(findAllCourses().spliterator(), false).filter(s -> s.getCourseName().equalsIgnoreCase(courseName)).findFirst();
		if(courseOptional.isPresent()) {
			return courseOptional.get();
		}
		else {
			throw new CourseNotFoundException("Course does not exists by that name", courseName);
		}
	}
	
	public Course findByCourseNumber(String courseNumber) {
		Optional<Course> courseOptional = StreamSupport.stream(findAllCourses().spliterator(), false).filter(s -> s.getCourseNumber().equalsIgnoreCase(courseNumber)).findFirst();
		if(courseOptional.isPresent()) {
			return courseOptional.get();
		}
		else {
			throw new CourseNotFoundException("Course Number does not Exist", courseNumber);
		}
	}
	
	public List<Course> findBySemesterOffered(String semesterOffered) {
		List<Course> courseList = StreamSupport.stream(findAllCourses().spliterator(), false).filter(s -> s.getSemesterOffered().equalsIgnoreCase(semesterOffered)).collect(Collectors.toList());
		if(courseList != null && !courseList.isEmpty()) {
			return courseList;
		}
		else {
			throw new CourseNotFoundException("No courses offered for this semester", semesterOffered);
		}
	}
	
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll();
	}
	
	public List<Student> findByFirstName(String fname) {
		List<Student> studentList = StreamSupport.stream(getAllStudents().spliterator(), false).filter(s -> s.getFirstName().equalsIgnoreCase(fname)).collect(Collectors.toList());
		if(studentList != null && !studentList.isEmpty()) {
			return studentList;
		}
		else {
			throw new StudentNotFoundException("Student does not exists by that name", fname);
		}
	}
	
	public Student findByStudentNumber(String studentNumber) {
		Optional<Student> student= StreamSupport.stream(getAllStudents().spliterator(), false).filter(s -> s.getStudentNumber().equalsIgnoreCase(studentNumber)).findFirst();
		if(student.isPresent()) {
			return student.get();
		}
		else {
			throw new StudentNotFoundException("Student Number does not Exist", studentNumber);
		}
	}
	
	private Iterable<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	

}
