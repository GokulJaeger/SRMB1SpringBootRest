package com.org.springrest5.springrest5.repository;

import com.org.springrest5.springrest5.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   
}
