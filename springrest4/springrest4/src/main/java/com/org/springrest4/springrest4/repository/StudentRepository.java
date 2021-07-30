package com.org.springrest4.springrest4.repository;

import java.util.List;

import com.org.springrest4.springrest4.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}
