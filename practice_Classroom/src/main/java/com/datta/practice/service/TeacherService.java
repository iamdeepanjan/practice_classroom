package com.datta.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datta.practice.exception.ResourceNotFoundException;
import com.datta.practice.model.Teacher;
import com.datta.practice.repository.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> findallTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher findTeacherById(Long id) {
		return teacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not found for this id: " + id));
	}

//	The	@Transactional annotation ensures that database	operations are handled atomically.
//	If any exception occurs	during the process the entire transaction is rolled back.

	@Transactional
	public Teacher saveTecher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@Transactional
    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = findTeacherById(id);
        teacher.setName(teacherDetails.getName());
        teacher.setSubject(teacherDetails.getSubject());
        teacher.setDepartment(teacherDetails.getDepartment());

        return teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacher(Long id) {
    	Teacher teacher = findTeacherById(id);
        teacherRepository.delete(teacher);
    }

}
