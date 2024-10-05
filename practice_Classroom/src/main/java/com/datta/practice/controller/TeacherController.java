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

import com.datta.practice.model.Teacher;
import com.datta.practice.service.TeacherService;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping("/teachers")
	public ResponseEntity<List<Teacher>> findAllTeacher() {
		return new ResponseEntity<List<Teacher>>(teacherService.findallTeachers(), HttpStatus.OK);
	}

	@GetMapping("/teachers/{id}")
	public ResponseEntity<Teacher> findTeacher(@PathVariable Long id) {
		return new ResponseEntity<Teacher>(teacherService.findTeacherById(id), HttpStatus.OK);
	}

	@PostMapping("/teachers")
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		return new ResponseEntity<Teacher>(teacherService.saveTecher(teacher), HttpStatus.CREATED);
	}

	@PutMapping("/teachers/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
		Teacher updatedTeacher = teacherService.updateTeacher(id, teacherDetails);
		return new ResponseEntity<Teacher>(updatedTeacher, HttpStatus.OK);
	}

	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacher(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
