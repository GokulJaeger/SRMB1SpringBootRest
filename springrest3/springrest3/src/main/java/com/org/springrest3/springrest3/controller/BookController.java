package com.org.springrest3.springrest3.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.domain.Page;  
import org.springframework.data.domain.Pageable;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import com.org.springrest3.springrest3.model.Book;
import com.org.springrest3.springrest3.model.Student;
import com.org.springrest3.springrest3.repository.BookRepository;
import com.org.springrest3.springrest3.repository.StudentRepository;

import java.net.URI;  
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {  
    private final BookRepository bookRepos;
    private final StudentRepository studentRepos;

    @Autowired
    public BookController(BookRepository bookRepos, StudentRepository studentRepos) {
        this.bookRepos = bookRepos;
        this.studentRepos = studentRepos;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book) {
        Optional<Student> optionalStudent = studentRepos.findById(book.getStudent().getId());
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setStudent(optionalStudent.get());

        Book savedBook = bookRepos.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedBook.getId()).toUri();

        return ResponseEntity.created(location).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody @Valid Book book, @PathVariable Integer id) {
        Optional<Student> optionalStudent = studentRepos.findById(book.getStudent().getId());
        if (!optionalStudent.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Book> optionalBook = bookRepos.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setStudent(optionalStudent.get());
        book.setId(optionalBook.get().getId());
        bookRepos.save(book);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Integer id) {
        Optional<Book> optionalBook = bookRepos.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        bookRepos.delete(optionalBook.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAll(Pageable pageable) {
        return ResponseEntity.ok(bookRepos.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        Optional<Book> optionalBook = bookRepos.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalBook.get());
    }
}
