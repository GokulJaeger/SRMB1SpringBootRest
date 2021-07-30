package com.example.springrest7.springrest7.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.springrest7.springrest7.model.Country;
import com.example.springrest7.springrest7.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository repo;

	@Override
	public List<Country> getCountries() {
		return repo.findAll();
	}

}
