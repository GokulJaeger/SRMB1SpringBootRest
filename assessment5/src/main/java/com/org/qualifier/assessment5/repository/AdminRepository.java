package com.org.qualifier.assessment5.repository;

import com.example.inventorymanagement.inventorymanagementspringboot.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
