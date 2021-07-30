package com.org.springrest3.springrest3.model;

/**
 * ManyToOne Mapping
 */
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;  
import javax.validation.constraints.NotNull;

@Entity
public class Book {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sid")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
