package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, String>{

}