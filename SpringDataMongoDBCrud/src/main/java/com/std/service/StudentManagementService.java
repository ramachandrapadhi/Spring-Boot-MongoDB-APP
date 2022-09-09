package com.std.service;

import java.util.List;

import com.std.document.Student;

public interface StudentManagementService {
	public Student addStudent(Student student);
	public Student updateStudent(Student student,String stdId);
	public Student getStudent(String stdId);
	public List<Student> getAll();
	public String delete(String stdId);
	public List<Student> getDataByMarksRange(Double start, Double end);

}
