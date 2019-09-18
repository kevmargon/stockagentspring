package com.stockagent.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "user")
	private String user;
	
	@Column (name = "pass")
	private String pass;
	
	@Column (name = "name")
	private String name;
	
	@Column(name = "surname1")
	private String surname1;
	
	@Column(name = "surname2")
	private String surname2;
	
	@Column (name = "dni")
	private String dni;
	
	@Column (name = "phone_number") 
	private String phoneNumber;
	
	//Unidirectional association to Direction
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_direction") //  Employee is the owner class
	private Direction direction;
	
	//Unidirectional association to Report
	@OneToOne (mappedBy = "employee", fetch = FetchType.LAZY) 
	private Report report;
	
	// Many-to-many association to Role
	@ManyToMany 
	@JoinTable(name = "employee_role",
	joinColumns = @JoinColumn(name = "id_employee", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"))
	private List<Role> roles = new ArrayList<>();
	
	// One-to-many association to Order
	@OneToMany(mappedBy = "employee", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) 
	private List<Order> orders;
	
	//CONSTRUCTORS
	public Employee() {
	}
	
	
	
	public Employee(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}



	public Employee(String user, String pass, String name, String surname1, String surname2, String dni,
			String phoneNumber, Direction direction, Report report) {
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
		this.direction = direction;
		this.report = report;
	}
	
	public Employee(String user, String pass, String name, String surname1, String surname2, String dni,
			String phoneNumber) {
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phoneNumber = phoneNumber;
	}



	// SET & GET METHODS
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getDni() {
		return dni;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Direction getDirection() {
		return direction;
	}

	public Report getReport() {
		return report;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
	/* Methods ascribing the employee and direction each other.
	 * The remove method can be used for detaching before deleting, if we want cascade not 
	 * to apply (not usual for oneToOne association).
	 */
	
	public void addDirection (Direction direction) {
		setDirection(direction);
		direction.setEmployee(this);
	}
	
	public void removeDirection (Direction direction) {
		setDirection(null);
		direction.setEmployee(null);
	}

	/* Methods for detaching  the employee from the 
	 * order, adding another employee or setting it to null.
	 * Use before deleting, so cascade does not apply.
	 */
	
	public void addOrder (Order order) {
		if(!orders.contains(order)) {
			getOrders().add(order);
			order.setEmployee(this);
		}
	}
	
	public void removeOrder (Order order) {
		if(orders.contains(order)) {
			getOrders().remove(order);
			order.setEmployee(null);
		}
	}
	
	/* Methods for detaching  the employee from the 
	 * role, adding another employee or setting it to null.
	 * Use before deleting, so cascade does not apply.
	 */
	public void addRole (Role role) {
		if(!roles.contains(role)) {
			getRoles().add(role);
			role.getEmployees().add(this);
		}
	}
	
	public void removeRole (Role role) {
		if(roles.contains(role)) {
			getRoles().remove(role);
			if(role.getEmployees().contains(this)){
				role.getEmployees().remove(this);
			}
		}
	}


}
