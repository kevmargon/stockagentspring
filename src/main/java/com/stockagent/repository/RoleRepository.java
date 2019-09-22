package com.stockagent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	@Query(value = "SELECT r FROM Role r INNER JOIN FETCH r.employees e WHERE e.id = :id") // , nativeQuery = true
	 //"SELECT p FROM Product p WHERE p.category.id =: id";
	List<Role> findByEmployeeId(@Param("id") Long id);

}