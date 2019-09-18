package com.stockagent.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Product;


@Entity
@Table(name="suppliers")
@NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")

public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "suppliers")
	private List<Product> products = new ArrayList<>();
	
	
	// CONSTRUCTORS

	public Supplier (){
	}

	public Supplier(String name) {
		this.name = name;
	}
	
	public Supplier(String name, List<Product> products) {
		this.name = name;
		this.products = products;
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
