package com.example.springrest7.springrest7.repository;

import com.example.springrest7.springrest7.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>  {

}
