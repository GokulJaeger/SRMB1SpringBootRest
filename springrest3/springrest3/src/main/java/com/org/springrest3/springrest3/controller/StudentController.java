package com.org.springrest3.springrest3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;  
// import org.springframework.data.domain.Page;  
// import org.springframework.data.domain.Pageable;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import com.org.springrest3.springrest3.model.Student;
import com.org.springrest3.springrest3.repository.BookRepository;
import com.org.springrest3.springrest3.repository.StudentRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;

// @Api(value="StudentController", description = "API Service that manages the different payment modes support by SwiftPayment API Project")
@RestController
@RequestMapping("/api/student")
public class StudentController {  
    private final StudentRepository studentRepo;
    private final BookRepository bookRepo;
    private Logger logg = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(StudentRepository studentRepo, BookRepository bookRepo) {
        this.studentRepo = studentRepo;
        this.bookRepo = bookRepo;
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        Student savedStud = studentRepo.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedStud.getId()).toUri();
        logg.info("Created!....");
        return ResponseEntity.created(location).body(savedStud);
    }

    // @ApiOperation(value="Creation of Customer Details", response = Iterable.class, tags = "regiserCustomer")
    // @ApiResponses(value={ 
    //     @ApiResponse(code = 200, message = "RSC-Success|OK"),
    //     @ApiResponse(code = 401, message = "RSC-not authorized!"), 
    //     @ApiResponse(code = 403, message = "RSC-forbidden!!!"),
    //     @ApiResponse(code = 404, message = "RSC-not found!!!") })
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @Valid @RequestBody Student student1) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (!optionalStudent.isPresent()) {
            logg.info("Updated Failed!....");
            return ResponseEntity.unprocessableEntity().build();
        }

        student1.setId(optionalStudent.get().getId());
        studentRepo.save(student1);
        logg.info("Updated!....");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Integer id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (!optionalStudent.isPresent()) {
            logg.info("Deletion Failed!....");
            return ResponseEntity.unprocessableEntity().build();
        }

        studentRepo.delete(optionalStudent.get());
        logg.info("Deleted!....");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (!optionalStudent.isPresent()) {
            logg.info("Fetch Failed!....");
            return ResponseEntity.unprocessableEntity().build();
        }
        logg.info("Fetched!....");
        return ResponseEntity.ok(optionalStudent.get());
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(Student student2) {
        logg.info("Fetched!....");
        return ResponseEntity.ok(studentRepo.findAll());
    }
}
