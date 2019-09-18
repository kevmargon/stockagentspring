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
	private Long id;

	@Column(name = "sell_date")
	private Date sellDate;

	@Column(name = "total_price")
	private BigDecimal totalPrice;

	@Column(name = "amount")
	private Integer amount;
	
	@ManyToMany(mappedBy = "orders")
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_employees")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customers")
	private Customer customer;
	
	// CONSTRUCTORS
	
	public Order (){
	}

	public Order(Date sellDate, BigDecimal totalPrice, Integer amount, Employee employee, Customer customer) {
		this.sellDate = sellDate;
		this.totalPrice = totalPrice;
		this.amount = amount;
		this.employee = employee;
		this.customer = customer;
	}
	
	public Order(Date sellDate, BigDecimal totalPrice, Integer amount) {
		this.sellDate = sellDate;
		this.totalPrice = totalPrice;
		this.amount = amount;
	}
	
	// GETTERS & SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}