package com.org.springrest4.springrest4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "vendor")
    private Set<Supplier> suppliergoods = new HashSet<>();

    public Vendor(String name){
        this.name = name;
    }

    public Object getId() {
        return null;
    }
}
