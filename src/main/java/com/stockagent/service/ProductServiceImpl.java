package com.stockagent.service;

import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.stockagent.model.Product;
import com.stockagent.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
		 log.debug("Request to save Product : {}", product);
	     return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		log.debug("Request to get all Products");
        return productRepository.findAll();
	}

	@Override
	public Optional<Product> findOne(Long id) {
		log.debug("Request to get Product : {}", id);
        return productRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
	}

	@Override
	public List<Product> findProductByCategoryId(Long id) {
		  log.debug("Request to find the list of Products from a Category : {}", id);
  		return productRepository.findByCategoryId(id);
	}




}
