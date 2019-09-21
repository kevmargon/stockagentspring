package com.stockagent.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Report;
import com.stockagent.repository.ReportRepository;
@Service
public class ReportServiceImpl implements ReportService {
	private final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public Report save(Report report) {
		 log.debug("Request to save Report : {}", report);
	     return reportRepository.save(report);
	}

	@Override
	public List<Report> findAll() {
		log.debug("Request to get all Reports");
        return reportRepository.findAll();
	}

	@Override
	public Optional<Report> findOne(Long id) {
		log.debug("Request to get Report : {}", id);
        return reportRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Report : {}", id);
        reportRepository.deleteById(id);
	}

	@Override
	public List<Report> findReportByIdEmployee(Long id) {
		  log.debug("Request to find the list of Reports from a Category : {}", id);
  		return reportRepository.findByIdEmployee(id);
	}

}
