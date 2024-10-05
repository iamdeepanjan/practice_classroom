package com.datta.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String subject;
	
//	@JsonIgnoreProperties: This annotation ensures that Hibernate-specific properties 
//	(hibernateLazyInitializer and handler) are ignored during serialization. This solves the 
//	problem of serializing lazy-loaded Department during GET requests without affecting 
//	the ability to set the Department during POST requests. now it won’t cause the 
//	JSON serialization issue because the proxy fields are ignored.
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignore proxy-specific fields
	private Department department;

	public Teacher() {
	}

	public Teacher(long id, String name, String subject, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public Department getDepartment() {
		return department;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + ", department=" + department + "]";
	}

}
