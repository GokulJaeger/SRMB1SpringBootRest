package com.org.spring.springrest1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<com.org.spring.springrest1.model.Employee, Long>{

}
