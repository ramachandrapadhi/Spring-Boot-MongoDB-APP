package com.std.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.common.ResponseMessage;
import com.std.document.Student;
import com.std.handller.ResourceNotFoundException;
import com.std.repository.StudentManagementRepository;

@Service("stdservice")
public class StudentManagementServiceImpl implements StudentManagementService {
	
	@Autowired
	private StudentManagementRepository repo;

	@Override
	public Student addStudent(Student student) {
		student = repo.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student, String stdId) {
		Student std = getStudent(stdId);
		student.setStdId(std.getStdId());
		return repo.save(student);
	}

	@Override
	public Student getStudent(String stdId) {
		Optional<Student> opt = repo.findById(stdId);
		Student student = opt.orElseThrow(()-> new ResourceNotFoundException(ResponseMessage.NO_DATA+" by ID : "+stdId));
		return student;
	}

	@Override
	public List<Student> getAll() {
		return repo.findAll();
	}

	@Override
	public String delete(String stdId) {
		getStudent(stdId);
		repo.deleteById(stdId);
		return stdId;
	}

	@Override
	public List<Student> getDataByMarksRange(Double start, Double end) {
		List<Student> list = repo.findByMarksBetween(start, end);
		return list;
	}
	
	
	
	
	
	
	

}
