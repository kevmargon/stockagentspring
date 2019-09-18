package com.stockagent.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Category;
import com.stockagent.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {
	private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		 log.debug("Request to save Category : {}", category);
	     return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		log.debug("Request to get all Categories");
        return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findOne(Long id) {
		log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.deleteById(id);
	}
	
}
