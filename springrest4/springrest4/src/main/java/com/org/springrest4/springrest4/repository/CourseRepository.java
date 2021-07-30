package com.org.springrest4.springrest4.repository;

import java.util.List;

import com.org.springrest4.springrest4.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}
