package com.std.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.common.Response;
import com.std.common.ResponseMessage;
import com.std.document.Student;
import com.std.service.StudentManagementService;

@RequestMapping("student/")
@RestController
public class StudentManagementController {

	@Autowired
	private StudentManagementService service;

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addStudent(@RequestBody Student student) {

		student = service.addStudent(student);

		Response resp = Response.builder()
				.ststus(true)
				.msg(ResponseMessage.CREATED + "ID : " + student.getStdId())
				.statusCode(HttpStatus.CREATED.value())
				.build();

		return new ResponseEntity<Response>(resp, HttpStatus.CREATED);
	}

	@PutMapping(path = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateStudent(
							@RequestBody Student student,
							@PathVariable("id") String stdId) {
		student = service.updateStudent(student, stdId);

		Response resp = Response.builder()
				.ststus(true)
				.msg(ResponseMessage.UPDATED + "ID : " + student.getStdId())
				.statusCode(HttpStatus.OK.value())
				.build();

		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	
	@GetMapping(path = "get/{id}")
	public ResponseEntity<Response> getStudent(@PathVariable("id") String stdId) {
		Student student = service.getStudent(stdId);
		Response resp = Response.builder()
				.ststus(true)
				.msg(ResponseMessage.GET)
				.statusCode(HttpStatus.OK.value())
				.data(student)
				.build();

		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	@GetMapping(path = "get")
	public ResponseEntity<Response> getAll() {
		List<Student> studentList = service.getAll();
		Response resp = Response.builder()
				.ststus(true)
				.msg(ResponseMessage.GET)
				.statusCode(HttpStatus.OK.value())
				.data(studentList)
				.build();
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable("id") String stdId) {
		String id = service.delete(stdId);
		Response resp = Response.builder()
				.ststus(true)
				.msg(ResponseMessage.DELETE)
				.data("Id "+id+" got deleted")
				.statusCode(HttpStatus.OK.value())
				.build();
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	
	@GetMapping(path = "get/{start}/{end}")
	public ResponseEntity<Response> getByMarksRange(@PathVariable("start") Double start, @PathVariable("end") Double end) {
		List<Student> studentList = service.getDataByMarksRange(start,end);
		Response resp = Response.builder()
				.ststus(true)
				.msg(ResponseMessage.GET)
				.statusCode(HttpStatus.OK.value())
				.data(studentList)
				.build();
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	
	
	

}
