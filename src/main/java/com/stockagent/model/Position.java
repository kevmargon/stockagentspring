package com.stockagent.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="positions")
@NamedQuery(name="position.findAll", query="SELECT e FROM Position e")
public class Position implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private long id;
	@Column (name = "name")
	private String name;
	
	// Bi-directional many-to-many association to Position
	@ManyToMany(mappedBy = "positions") //REV: Lazy??
	private List<Employee> employees = new ArrayList<>();

	// CONSTRUCTORES
	public Position() {
		
	}
	
	public Position(String name) {
		this.name = name;
	}
	
	// GETTERS & SETTERS

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//ADDITIONAL METHODS
	/* Methods for detaching  the position from the 
	 * employee, adding another position or setting it to null.
	 * Use before deleting, so cascade does not apply.
	 */
	//REV: hacen falta estos m�todos para un manytomany???????????
	/*public void addEmployee (Employee employee) {
		if(!employees.contains(employee)) {
			getEmployees().add(employee);
			employee.setPositions(this);
		}
	}

	public void removeEmployee (Employee employee) {
		if(employees.contains(employee)) {
			getEmployees().remove(employee);
			employee.setPositions(null);
		}
	}*/
	
}
