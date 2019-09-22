package com.stockagent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="reports")
@NamedQuery(name="report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "description")
	private String description;
	
	@Column (name = "date")
	private Date dateTime;
	
	//Unidirectional association to Employee
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_employee") //  Report is the owner class
	private Employee employee;

	// CONSTRUCTOR
	
	public Report() {

	}
	
	public Report(String description, Date dateTime) {
		this.description = description;
		this.dateTime = dateTime;
	}

	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//ADDITIONAL METHODS
	/* Methods ascribing the report and employee each other.
	 * The remove method can be used for detaching before deleting, if we want cascade not 
	 * to apply (not usual for oneToOne association).
	 */
	
//	public void addEmployee (Employee employee) {
//		setEmployee(employee);
//		employee.setReports(this);
//	}
//	
//	public void removeEmployee (Employee employee) {
//		setEmployee(null);
//		employee.setReports(null);
//	}

}
