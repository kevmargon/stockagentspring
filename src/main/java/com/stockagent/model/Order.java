package com.stockagent.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

//	Alan: Como ser�a el campo Date vs DateTime(Para no usar now) en la base de datos traido desde Java 
//	Capturar fecha en "instant"
	@Column(name = "sell_date")
	private Date sellDate;

	@Column(name = "total_price")
	private BigDecimal totalPrice;

	@Column(name = "amount")
	private int amount;
	
	@ManyToMany(mappedBy = "orders")
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_employees")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customers")
	private Customer customers;
	
	public Order (){
	}

	public Order(Date sellDate, BigDecimal totalPrice, int amount, Employee employee, Customer customers) {
		this.sellDate = sellDate;
		this.totalPrice = totalPrice;
		this.amount = amount;
		this.employee = employee;
		this.customers = customers;
	}
	
	public Order(Date sellDate, BigDecimal totalPrice, int amount) {
		this.sellDate = sellDate;
		this.totalPrice = totalPrice;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}