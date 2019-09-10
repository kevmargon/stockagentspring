package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}