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

import com.datta.practice.model.Department;
import com.datta.practice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getDepartments(){
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/departments")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentRepository.save(department), HttpStatus.CREATED);
	}

}
