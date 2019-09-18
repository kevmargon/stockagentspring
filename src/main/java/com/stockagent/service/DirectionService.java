package com.stockagent.service;
import java.util.List;

import java.util.Optional;

import com.stockagent.model.Direction;
/**
 * Service Interface for managing Direction.
 */
public interface DirectionService{
	/**
	 * Save a direction
	 * @param direction
	 * @return
	 */
	Direction save(Direction direction);
	
	/**
	 * Get all directions
	 * @return
	 */
	List<Direction> findAll();
	
	/**
	 * Get one direction by id
	 * @param id
	 * @return
	 */
	Optional<Direction> findOne(Long id);
	
	/**
	 * It deletes one direction by id
	 * @param id
	 */
	void delete(Long id);

}
