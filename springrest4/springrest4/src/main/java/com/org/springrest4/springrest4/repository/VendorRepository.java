package com.org.springrest4.springrest4.repository;

import com.org.springrest4.springrest4.model.Vendor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    
}
