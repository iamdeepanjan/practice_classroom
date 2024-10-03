package com.datta.practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

	public Department() {
	}

	public Department(long id, String subject) {
		super();
		this.id = id;
		this.subject = subject;
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", subject=" + subject + "]";
	}

}
