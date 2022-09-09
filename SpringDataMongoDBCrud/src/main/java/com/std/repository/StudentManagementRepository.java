package com.std.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.std.document.Student;

public interface StudentManagementRepository extends MongoRepository<Student, String> {
	
	public List<Student> findByMarksBetween(double start,double end);

}
