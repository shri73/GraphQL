package com.example.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.model.Course;
import com.example.graphql.model.Student;
import com.example.graphql.model.StudentInput;
import com.example.graphql.repository.CourseRepository;
import com.example.graphql.repository.StudentRepository;

@Component
public class Mutation implements GraphQLMutationResolver{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Student newStudent(StudentInput input) {
		Student student = new Student();
		student.setFirstName(input.getFirstName());
		student.setLastName(input.getLastName());
		student.setStudentNumber(input.getStudentNumber());
		student.setYear(input.getYear());
		student.setEmail(input.getEmail());
		studentRepository.save(student);
		return student;
	}
	
	public Course newCourse(String courseName, String courseNumber, Integer credits, String semesterOffered) {
		Course course = new Course();
		course.setCourseName(courseName);
		course.setCourseNumber(courseNumber);
		course.setCredits(credits);
		course.setSemesterOffered(semesterOffered);
		courseRepository.save(course);
		return course;
	}
	
	public Student addCourseToStudent(String courseNumber, String studentNumber) {
		Optional<Course> getCourseOptional = courseRepository.findByCourseNumber(courseNumber);
		Student student = new Student();
		Course course = new Course();
		if(getCourseOptional.isPresent()) {
			Optional<Student> getStudent = studentRepository.findByStudentNumber(studentNumber);
			course = getCourseOptional.get();
			if(getStudent.isPresent()) {
				student = getStudent.get();
				student.getCourses().add(course);
				course.getStudents().add(student);
				courseRepository.save(course);
			}
		}
		return studentRepository.save(student);
		
	}
	
}
