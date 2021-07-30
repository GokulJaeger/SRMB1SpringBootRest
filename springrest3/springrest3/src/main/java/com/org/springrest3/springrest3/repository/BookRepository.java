package com.org.springrest3.springrest3.repository;

import com.org.springrest3.springrest3.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
