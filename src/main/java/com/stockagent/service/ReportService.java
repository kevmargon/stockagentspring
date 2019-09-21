package com.stockagent.service;
import java.util.List;
import java.util.Optional;

import com.stockagent.model.Report;
/**
 * Service Interface for managing Report.
 */
public interface ReportService{
	/**
	 * Save a report
	 * @param report
	 * @return
	 */
	Report save(Report report);
	
	/**
	 * Get all reports
	 * @return
	 */
	List<Report> findAll();
	
	/**
	 * Get one report by id
	 * @param id
	 * @return
	 */
	Optional<Report> findOne(Long id);
	
	/**
	 * It deletes one report by id
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Get list of reports by category id
	 * @param id
	 * @return
	 */
	List<Report> findReportByIdEmployee(Long id);
	


}
