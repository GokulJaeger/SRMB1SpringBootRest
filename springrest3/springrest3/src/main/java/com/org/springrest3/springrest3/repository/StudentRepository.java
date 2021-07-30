package com.org.springrest3.springrest3.repository;

import com.org.springrest3.springrest3.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
