package com.stockagent.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Employee;
import com.stockagent.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		 log.debug("Request to save Employee : {}", employee);
	     return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		log.debug("Request to get all Employees");
        return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findOne(Long id) {
		log.debug("Request to get Employee : {}", id);
        return employeeRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Employee : {}", id);
        employeeRepository.deleteById(id);
	}
	
	@Override
	public List<Employee> findList(Long id) {
		log.debug("Request to get list of employees by id");
		
        return employeeRepository.findListById(id);
	}



}
