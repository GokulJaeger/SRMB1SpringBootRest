package com.org.springrest5.springrest5.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.org.springrest5.springrest5.exception.ResourceNotFoundException;
import com.org.springrest5.springrest5.model.Customer;
import com.org.springrest5.springrest5.repository.CustomerRepository;

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
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/customer")
    public List<Customer> getInstructors() {
        return customerRepo.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity < Customer > getInstructorById(
        @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
            Customer user = customerRepo.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/customer")
    public Customer createUser(@Valid @RequestBody Customer instructor) {
        return customerRepo.save(instructor);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity < Customer > updateUser(
        @PathVariable(value = "id") Long instructorId,
        @Valid @RequestBody Customer userDetails) throws ResourceNotFoundException {
            Customer user = customerRepo.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
        user.setEmail(userDetails.getEmail());
        final Customer updatedUser = customerRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/customer/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Long instructorId) throws ResourceNotFoundException {
            Customer instructor = customerRepo.findById(instructorId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

            customerRepo.delete(instructor);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
