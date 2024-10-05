package com.datta.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datta.practice.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
