package com.stockagent.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="directions")
@NamedQuery(name="Direction.findAll", query="SELECT d FROM Direction d")
public class Direction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "house_number")
	private Integer houseNumber;
	
	@Column (name = "zip_code")
	private Integer zipCode;
	
	@Column (name = "city")
	private String city;
	
	@Column (name = "province")
	private String province;
	
	@Column (name = "country")
	private String country;
	
	// Unidirectional one-to-one association to Employee
	@OneToOne (mappedBy = "direction", fetch = FetchType.LAZY) 
	private Employee employee;
	
	// Unidirectional one-to-one association to Customer
	@OneToOne (mappedBy = "direction", fetch = FetchType.LAZY) 
	private Customer customer;

	
	// CONSTRUCTORS

	public Direction() {
	}

	public Direction(String address, Integer houseNumber, Integer zipCode, String city, String province, String country) {
		this.address = address;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.province = province;
		this.country = country;
	}

	// GETTERS & SETTERS
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getCountry() {
		return country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
