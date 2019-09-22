package com.stockagent.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stockagent.model.Employee;
import com.stockagent.model.Report;
import com.stockagent.service.EmployeeService;
import com.stockagent.service.ReportService;


@Controller

public class ReportController {
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private ReportService reportService;
	@Autowired
	private EmployeeService employeeService;
	
//	I declare 'notification' and 'notificationLabel' as class variables so that they are easy to 
//	share and pass through one method to the other (from the Post method for saving reports and the Get for deleting
//	to the Get for showing the list reports (getAllReports)...

	public String notification = null;
	public String notificationLabel = null;
	

	@GetMapping("/reports")
	public String root() {
		return "redirect:/reports/list";
	}

	@GetMapping("/reports/list")
	public ModelAndView getAllReports() {
		log.debug("request to get Reports");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report-list");
		mav.addObject("reports", reportService.findAll());
		mav.addObject("employees", employeeService.findAll());
		mav.addObject("notification", notification);
		mav.addObject("notificationLabel", notificationLabel);
		notification = null;
		notificationLabel = null;
		return mav;
	}

	@GetMapping("/reports/empty")
	public ModelAndView createReport() {
		log.debug("request to empty report form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reports-form");
//		The same jsp view file is used for the report editing form and  new report inserting one.
		mav.addObject("report", new Report());
		notification = null;
		notificationLabel = null;
		return mav;
	}

	/**
	 * GET /reports/:id : get the "id" report.
	 *
	 * @param id the id of the report to retrieve
	 * @return
	 */
	@GetMapping("/reports/{id}")
	public ModelAndView getReport(@PathVariable Long id) {
		log.debug("request to get Report : {}", id);
		Optional<Report> report = reportService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (report.isPresent()) {
			mav.setViewName("report-edit");
			mav.addObject("report", report.get());
//			mav.addObject("employees", employeeRepository.findAll());
//			mav.addObject("suppliers", supplierRepository.findAll());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("report-list");
			mav.addObject("message", "Report not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}

	/**
	 * POST /reports
	 *
	 * @ModelAttribute report : Data of the object (javaBean/Entity) report to save
	 * @return
	 */

	@PostMapping("/reports")
	public String saveReport(@ModelAttribute("description") String description,	@ModelAttribute("employeeid") Long employeeid){ 
		
		log.debug("request to check User (employee) : {}, {}", description, employeeid);
		Report report = new Report();
		Employee employee = new Employee();
		Instant instant= Instant.now();
		Timestamp timestamp= Timestamp.from(instant);
		report.setDateTime(timestamp);
		report.setDescription(description);
		List <Employee> employees = employeeService.findList(employeeid);
		for(Employee e: employees) {
			employee = e;
		}
		report.setEmployee(employee);

		if (reportService.save(report) != null) {
			notification = "The report has been updated succesfully!";
			notificationLabel = "success";

		} else {
			notification = "ERROR. The report could not be updated succesfully.";
			notificationLabel = "error";

		}

		return "redirect:/reports";
	}

	/**
	 * GET /reports/:id/delete : delete the "id" report.
	 *
	 * @param id the id of the report to delete
	 * @return
	 */

	@GetMapping("/reports/{id}/delete")
	public String deleteReport(@PathVariable Long id) {
		log.debug("request to delete Report : {}", id);
		reportService.delete(id);
		notification = "The report has been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/reports";
	}

}
