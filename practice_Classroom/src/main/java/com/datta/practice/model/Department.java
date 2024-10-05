package com.datta.practice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String subject;
	
//	CascadeType.ALL: This means that any operation (e.g., delete) performed on Department
//	will be cascaded to its related Student entities. orphanRemoval = true: This ensures 
//	that if a Student is removed from the Department entity list, it is also removed from the database.
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Student> students;

	public Department() {
	}

	public Department(long id, String subject, List<Student> students) {
		super();
		this.id = id;
		this.subject = subject;
		this.students = students;
	}

	public long getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", subject=" + subject + "]";
	}

}
