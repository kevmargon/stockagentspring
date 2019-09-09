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
	private long id;
	
	@Column (name = "address")
	private String address;
	
	@Column (name = "housenumber")
	private int houseNumber;
	
	@Column (name = "zipcode")
	private int zipCode;
	
	@Column (name = "city")
	private String city;
	
	@Column (name = "province")
	private String province;
	
	@Column (name = "country")
	private String country;
	
	// Unidirectional association to Employee
	@OneToOne (mappedBy = "direction", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) //REV: podemos Lazy??, realmente queremos que se eliminen en cascada los report al eliminar su employee?, si no problems, habr�a que desvincular
	private Employee employee;
	
	// Unidirectional association to Customer
	@OneToOne (mappedBy = "direction", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) //REV: podemos Lazy??, realmente queremos que se eliminen en cascada los report al eliminar su employee?, si no problems, habr�a que desvincular
	private Customer customer;

	
	// CONSTRUCTORS

	public Direction() {
	}

	public Direction(String address, int houseNumber, int zipCode, String city, String province, String country) {
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

	public long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public int getZipCode() {
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

	public void setId(long id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setZipCode(int zipCode) {
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
