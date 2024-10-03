package com.datta.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datta.practice.model.Student;
import com.datta.practice.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getDepartments(){
		return new ResponseEntity<List<Student>>(studentRepository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createDepartment(@RequestBody Student student){
		return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.CREATED);
	}

}
