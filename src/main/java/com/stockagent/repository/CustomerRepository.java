package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}