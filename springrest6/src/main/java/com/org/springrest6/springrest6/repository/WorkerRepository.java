package com.org.springrest6.springrest6.repository;

import com.org.springrest6.springrest6.model.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
