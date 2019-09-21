package com.stockagent.service;
import java.util.List;
import java.util.Optional;

import com.stockagent.model.Employee;
/**
 * Service Interface for managing Employee.
 */
public interface EmployeeService{
	/**
	 * Save a employee
	 * @param employee
	 * @return
	 */
	Employee save(Employee employee);
	
	/**
	 * Get all employees
	 * @return
	 */
	List<Employee> findAll();
	
	/**
	 * Get one employee by id
	 * @param id
	 * @return
	 */
	Optional<Employee> findOne(Long id);
	
	/**
	 * It deletes one employee by id
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Get list of employees by category id
	 * @param id
	 * @return
	 */	


}
