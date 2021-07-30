package com.org.springrest4.springrest4.repository;

import com.org.springrest4.springrest4.model.Goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    
}
