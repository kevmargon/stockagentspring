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
	List<Product> products = new ArrayList<>();
	
	// CONSTRUCTORS

	public Category (){
	}

	public Category(String name) {
		this.name = name;
	}

	// GETTERS & SETTERS
	
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	//ADDITIONAL METHODS

		/* Methods for detaching  the category from the 
		 * product, adding another category or setting it to null.
		 * Use before deleting, so cascade does not apply.
		 * 
		 */
		
		public void addProduct (Product product) {
			if(!products.contains(product)) {
				getProducts().add(product);
				product.setCategory(this);
			}
		}
		
		public void removeProduct (Product product) {
			if(products.contains(product)) {
				getProducts().remove(product);
				product.setCategory(null);
			}
}
}
