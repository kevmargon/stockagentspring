package com.stockagent.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Supplier;
import com.stockagent.repository.SupplierRepository;
@Service
public class SupplierServiceImpl implements SupplierService {
	private final Logger log = LoggerFactory.getLogger(SupplierServiceImpl.class);
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public Supplier save(Supplier supplier) {
		 log.debug("Request to save Supplier : {}", supplier);
	     return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> findAll() {
		log.debug("Request to get all Suppliers");
        return supplierRepository.findAll();
	}

	@Override
	public Optional<Supplier> findOne(Long id) {
		log.debug("Request to get Supplier : {}", id);
        return supplierRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Supplier : {}", id);
        supplierRepository.deleteById(id);
	}	
	
}
