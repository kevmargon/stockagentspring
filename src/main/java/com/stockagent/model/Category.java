package com.stockagent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Product;


@Entity
@Table(name="categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	List<Product> product = new ArrayList<>();

	public Category (){
	}

	public Category(String name) {
		this.name = name;
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
}
