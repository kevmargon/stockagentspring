package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}