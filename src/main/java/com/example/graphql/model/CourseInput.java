package com.example.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInput {

	
	private String courseName ;
	
	
	private String courseNumber;
	
	
	private int credits;
	
	
	private String semesterOffered;
}
