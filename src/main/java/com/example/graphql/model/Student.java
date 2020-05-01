package com.example.graphql.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false, exclude = {"courses"})
public class Student {
	@Id
	@Column(name = "studentNumber", unique = true, nullable = false)
	private String studentNumber;
	
	@Column(name = "firstName", nullable = false)
	@NotNull(message = "First Name cannot be null")
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	@NotNull(message = "Last Name cannot be null")
	private String lastName;
	
	@Column(name = "year", nullable = false)
	private String year;
	
	@Column(name = "email", nullable = false)
	@Email(message = "Email should be valid")
	private String email;
	
	
	@ManyToMany(
	        cascade = CascadeType.ALL,
	        fetch = FetchType.EAGER,
	        mappedBy = "students"
	    )
    private List<Course> courses = new ArrayList<Course>();
	
	

}
