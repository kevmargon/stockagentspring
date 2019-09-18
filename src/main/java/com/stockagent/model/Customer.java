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
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "surname1")
	private String surname1;
	
	@Column(name = "surname2")
	private String surname2;

	@Column(name = "dni")
	private String dni;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_direction") // owner
	private Direction direction;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Order> orders = new ArrayList<>();
	
	// CONSTRUCTORS

	public Customer() {
	}
	
	public Customer(String name, String surname1, String surname2, String dni, String phoneNumber) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer(String name, String surname1, String surname2, String dni, String phoneNumber,
			Direction direction, List<Order> orders) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
		this.direction = direction;
		this.orders = orders;
	}

	public Customer(String name, String surname1, String surname2, String dni, String phoneNumber, Direction direction) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
		this.direction = direction;
	}

	// GETTERS & SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrder(List<Order> orders) {
		this.orders = orders;
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
	//ADDITIONAL METHODS
	/* Methods ascribing the customer and direction each other.
	 * The remove method can be used for detaching before deleting, if we want cascade not 
	 * to apply (not usual for oneToOne association).
	 */
	
	public void addDirection (Direction direction) {
		setDirection(direction);
		direction.setCustomer(this);
	}
	
	public void removeDirection (Direction direction) {
		setDirection(null);
		direction.setCustomer(null);
	}

	/* Methods for detaching  the customer from the 
	 * order, adding another customer or setting it to null.
	 * Use before deleting, so cascade does not apply.
	 */
	
	public void addOrder (Order order) {
		if(!orders.contains(order)) {
			getOrders().add(order);
			order.setCustomer(this);
		}
	}
	
	public void removeOrder (Order order) {
		if(orders.contains(order)) {
			getOrders().remove(order);
			order.setCustomer(null);
		}
	}
	

	
}
