package com.stockagent.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	/**
	 * ADDICIONAL JPA method /findByUserAndPass: . Searches and selects the employee with a certain User and Password.
	 * 
	 * @param user: the Log-in enter user of the employee
	 * @param pass: the Log-in enter pass of the employee
	 * @return List <Employee>
	 */
	@Query(value = "SELECT e FROM Employee e WHERE e.user = :user AND e.pass = :pass") 
	List<Employee> findByUserAndPass(@Param("user") String user, @Param("pass") String pass );
	
	/**
	 * ADDICIONAL JPA method /findByUser: . Searches and selects the employee with a certain User.
	 * 
	 * @param user: the Log-in enter user generated for/by the employee
	 * @return List <Employee>
	 */
	@Query(value = "SELECT e FROM Employee e WHERE e.user = :user")
	List<Employee> findByUser(@Param("user") String user );
	/**
	 * ADDICIONAL JPA method /findListById: . Searches and selects the employee with a certain id and returns a List<Employee>
	 *  (instead of a List<Optional> as the JPA available method).
	 * 
	 * @param id.
	 * @return List <Employee>
	 */
	@Query(value = "SELECT e FROM Employee e WHERE e.id = :id")
	List<Employee> findListById(@Param("id") Long id );
	
	
}