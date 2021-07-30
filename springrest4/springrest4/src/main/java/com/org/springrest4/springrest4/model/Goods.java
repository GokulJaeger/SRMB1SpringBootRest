package com.org.springrest4.springrest4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Goods{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Supplier> supplier = new HashSet<>();

    public Goods(String name) {
        this.name = name;
    }

    public Object getId() {
        return null;
    }
}
