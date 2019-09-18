package com.stockagent.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stockagent.model.Supplier;
/**
 * Service Interface for managing Supplier.
 */
@Service
public interface SupplierService{
	/**
	 * Save a supplier
	 * @param supplier
	 * @return
	 */
	Supplier save(Supplier supplier);
	
	/**
	 * Get all suppliers
	 * @return
	 */
	List<Supplier> findAll();
	
	/**
	 * Get one supplier by id
	 * @param id
	 * @return
	 */
	Optional<Supplier> findOne(Long id);
	
	/**
	 * It deletes one supplier by id
	 * @param id
	 */
	void delete(Long id);


}
