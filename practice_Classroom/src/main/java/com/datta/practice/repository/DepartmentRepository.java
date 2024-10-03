package com.datta.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datta.practice.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
