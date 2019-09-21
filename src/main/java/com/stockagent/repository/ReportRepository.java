package com.stockagent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockagent.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{
	/**
	 * ADDICIONAL JPA method /findByIEmployee: . Searches and selects the list of
	 * reports of a certain employee.
	 * 
	 * @param id the id of the related employee
	 * @return List <Report>
	 */
	@Query(value = "SELECT r FROM Report r INNER JOIN FETCH r.employee e WHERE e.id = :id") // , nativeQuery = true
	 //"SELECT p FROM Report p WHERE p.category.id =: id";
	List<Report> findByIdEmployee(@Param("id") Long id);

}