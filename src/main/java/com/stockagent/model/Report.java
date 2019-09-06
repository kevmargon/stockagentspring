package com.stockagent.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reports")
@NamedQuery(name="report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private long id;
	@Column (name = "description")
	private String description;
	@Column (name = "date")
	private Date dateTime;// ALAN: preguntar tipo de dato (tb en clase order) (puse de paquete util per tb habia de sql)
	
	//Unidirectional association to Employee
	@OneToOne(cascade = {CascadeType.ALL}) 
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
