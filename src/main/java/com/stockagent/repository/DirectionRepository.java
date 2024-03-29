package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Direction;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long>{

}