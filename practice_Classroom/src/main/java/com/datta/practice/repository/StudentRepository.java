package com.datta.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datta.practice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
