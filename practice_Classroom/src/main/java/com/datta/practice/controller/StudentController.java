package com.datta.practice.controller;

import java.util.List;

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

import com.datta.practice.model.Student;
import com.datta.practice.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
		
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<List<Student>>(studentService.findallStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id){
		return new ResponseEntity<Student>(studentService.findStudentById(id),HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	 @PutMapping("/students/{id}")
	 public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	     Student updatedStudent = studentService.updateStudent(id, studentDetails);
	     return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/students/{id}")
	 public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		 studentService.deleteStudent(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	

}
