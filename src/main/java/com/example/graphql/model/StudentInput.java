package com.example.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInput {
	
	private String studentNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String year;
	
	private String email;
	
}
