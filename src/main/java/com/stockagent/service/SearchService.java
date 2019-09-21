package com.stockagent.service;

import java.util.List;

import com.stockagent.model.Product;

/**
 * Service Interface for managing Product.
 */

public interface SearchService{
	/**
	 * Return all the coincidences for the nameOfProduct into the database.
	 * @param nameOfProduct
	 * @return
	 */
	List<Product> searchProduct(String name);
	
}
