package com.org.springrest6.springrest6.controller;

/**
 * Spring Exception
 * Logger
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.org.springrest6.springrest6.exception.ResourceNotFoundException;
import com.org.springrest6.springrest6.model.Worker;
import com.org.springrest6.springrest6.repository.WorkerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WorkerController {

    private Logger log = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/worker")
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @GetMapping("/worker/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable(value = "id") Long workerId)
            throws ResourceNotFoundException {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + workerId));
        log.info("Data's fetched: " + worker.toString());
        return ResponseEntity.ok().body(worker);
    }

    @PostMapping("/worker")
    public Worker createWorker(@Valid @RequestBody Worker worker) throws ResourceNotFoundException {
        log.info("Inserted!...");
        return workerRepository.save(worker);
    }

    @PutMapping("/worker/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable(value = "id") Long workerId,
            @Valid @RequestBody Worker workDetails) throws ResourceNotFoundException {
        Worker worker = workerRepository.findById(workerId).orElseThrow(
                () -> new ResourceNotFoundException("Employee cannot be found for this id :: " + workerId));

        worker.setEmail(workDetails.getEmail());
        worker.setLname(workDetails.getLname());
        worker.setFname(workDetails.getFname());
        final Worker updatedWorker = workerRepository.save(worker);
        log.info("Updated!...");
        return ResponseEntity.ok(updatedWorker);
    }

    @DeleteMapping("/worker/{id}")
    public Map<String, Boolean> deleteWorker(@PathVariable(value = "id") Long workerId)
            throws ResourceNotFoundException {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + workerId));

        workerRepository.delete(worker);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        log.info("Deleted!....");
        return response;
    }
}