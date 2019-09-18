package com.stockagent.service;
import java.util.List;

import java.util.Optional;

import com.stockagent.model.Category;
/**
 * Service Interface for managing Category.
 */
public interface CategoryService{
	/**
	 * Save a category
	 * @param category
	 * @return
	 */
	Category save(Category category);
	
	/**
	 * Get all categories
	 * @return
	 */
	List<Category> findAll();
	
	/**
	 * Get one category by id
	 * @param id
	 * @return
	 */
	Optional<Category> findOne(Long id);
	
	/**
	 * It deletes one category by id
	 * @param id
	 */
	void delete(Long id);

}
