package com.org.spring.springrest1.repository;

import com.org.spring.springrest1.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long>{
    
}
