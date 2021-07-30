package com.org.spring.springrest1.controller;

import java.util.List;

import javax.validation.Valid;

import com.org.spring.springrest1.exception.ResourceNotFoundException;
import com.org.spring.springrest1.model.Product;
import com.org.spring.springrest1.repository.ProductRepo;

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
public class ProductController {

    @Autowired
    private ProductRepo prodrepo;

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return prodrepo.findAll();
    }

    @PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product prod) {
        return prodrepo.save(prod);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(value = "id") Long pid1) {
        return prodrepo.findById(pid1).orElseThrow(() -> new ResourceNotFoundException("Product", "id", pid1));
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long pid2, @Valid @RequestBody Product prod1) {
        Product prd = prodrepo.findById(pid2).orElseThrow(()-> new ResourceNotFoundException("Product to PutMapping", "id", pid2));

        prd.setPid(prod1.getPid());
        prd.setPname(prod1.getPname());
        prd.setPcategory(prod1.getPcategory());

        Product uprod = prodrepo.save(prd);

        return uprod;
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Long pid3){
        Product prd = prodrepo.findById(pid3).orElseThrow(()-> new ResourceNotFoundException("Product to Delete", "id", pid3));
        
        prodrepo.delete(prd);
        return ResponseEntity.ok().build();
    }
}
