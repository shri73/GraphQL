package com.example.graphql.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {

	@Column(name = "Course_name", nullable = false)
	@NotNull(message = "Course Name cannot be null")
	private String courseName ;
	
	@Id
	@Column(name = "Course_Number", unique = true, nullable = false)
	private String courseNumber;
	
	@Column(name = "Credits", nullable = false)
	@PositiveOrZero
	private int credits;
	
	@Column(name = "Semester_Offered", nullable = false)
	private String semesterOffered;
	
	
	@ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "course_number", referencedColumnName = "Course_Number"),
        inverseJoinColumns = @JoinColumn(name = "student_number", referencedColumnName = "studentNumber"))
	private List<Student> students = new ArrayList<Student>();
	
	
	
}
