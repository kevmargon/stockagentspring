package com.stockagent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Order;
import com.stockagent.model.Direction;

@Entity
@Table(name = "customers")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "surname1")
	private String surname1;
	
	@Column(name = "surname2")
	private String surname2;

	@Column(name = "dni")
	private String dni;
	
	@Column(name = "phonenumber")
	private int phoneNumber;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_direction") // owner
	private Direction direction;
	
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	List<Order> order = new ArrayList<>();
	
	public Customer() {
	}
	
	public Customer(String name, String surname1, String surname2, String dni, int phoneNumber) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer(String name, String surname1, String surname2, String dni, int phoneNumber,
			Direction direction, List<Order> order) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
		this.direction = direction;
		this.order = order;
	}

	public Customer(String name, String surname1, String surname2, String dni, int phoneNumber, Direction direction) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
		this.direction = direction;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}
	
}
