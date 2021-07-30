package com.org.springrest4.springrest4.repository;

import com.org.springrest4.springrest4.model.Supplier;
import com.org.springrest4.springrest4.model.SupplierId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, SupplierId> {
    
}
