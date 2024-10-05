package com.datta.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datta.practice.model.Department;
import com.datta.practice.repository.DepartmentRepository;
import com.datta.practice.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getDepartments(){
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return new ResponseEntity<>(department.get(), HttpStatus.OK);
        } else {
        	throw new ResourceNotFoundException("Department not found for this id: " + id);
        }
    }
	
	@PostMapping("/departments")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentRepository.save(department), HttpStatus.CREATED);
	}
	
	 @PutMapping("/departments/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
	        Optional<Department> departmentOptional = departmentRepository.findById(id);
	        if (departmentOptional.isPresent()) {
	            Department department = departmentOptional.get();
	            department.setSubject(departmentDetails.getSubject()); 
	            Department updatedDepartment = departmentRepository.save(department);
	            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
	        } else {
	        	throw new ResourceNotFoundException("Department not found for this id: " + id);
	        }
	    }
	 
	 @DeleteMapping("/departments/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
	        Optional<Department> department = departmentRepository.findById(id);
	        if (department.isPresent()) {
	            departmentRepository.delete(department.get());
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	        	throw new ResourceNotFoundException("Department not found for this id: " + id);
	        }
	    }

}
