package com.org.springrest4.springrest4.repository;

import java.util.List;

import com.org.springrest4.springrest4.model.Employee;
import com.org.springrest4.springrest4.model.EmployeeId;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {

    List<Employee> findByEmployeeIdDepartmentId(Long departmentId);
}
