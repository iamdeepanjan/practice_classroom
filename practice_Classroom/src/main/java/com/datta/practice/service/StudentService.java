package com.datta.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datta.practice.exception.ResourceNotFoundException;
import com.datta.practice.model.Student;
import com.datta.practice.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findallStudents() {
		return studentRepository.findAll();
	}

	public Student findStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id: " + id));
	}

//	The	@Transactional annotation ensures that database	operations are handled atomically.
//	If any exception occurs	during the process the entire transaction is rolled back.

	@Transactional
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Transactional
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = findStudentById(id);
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setAge(studentDetails.getAge());
        student.setDepartment(studentDetails.getDepartment());

        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Long id) {
    	Student student = findStudentById(id);
        studentRepository.delete(student);
    }

}
