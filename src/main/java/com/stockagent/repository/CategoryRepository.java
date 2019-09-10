package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}