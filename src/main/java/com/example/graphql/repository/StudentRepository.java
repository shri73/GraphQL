package com.example.graphql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.graphql.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	Optional<List<Student>> findByFirstName(String fname);
	Optional<Student> findByStudentNumber(String sNumber);

}
