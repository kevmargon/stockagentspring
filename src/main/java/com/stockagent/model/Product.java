package com.stockagent.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.stockagent.model.Supplier;
import com.stockagent.model.Category;
import com.stockagent.model.Order;

@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "manufacturer")
	private String manufacturer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categories")
	private Category category;

	@ManyToMany
	@JoinTable(name = "product_supplier", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "id"))
	private List<Supplier> suppliers = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "product_order", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
	private List<Order> orders = new ArrayList<>();

	// CONSTRUCTORS

	public Product() {
	}

	public Product(String name, BigDecimal price, Integer amount, String manufacturer, Category category) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.manufacturer = manufacturer;
		this.category = category;
	}
	
	public Product(String name, BigDecimal price, Integer amount, String manufacturer) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.manufacturer = manufacturer;
	}
	
	public Product(String name, BigDecimal price, Integer amount, String manufacturer, Category category, List<Supplier> supplier,
			List<Order> order) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.manufacturer = manufacturer;
		this.category = category;
		this.suppliers = supplier;
		this.orders = order;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//ADDITIONAL METHODS
				
		/* Methods for detaching  the product from the 
		 * supplier, adding another product or setting it to null.
		 * Use before deleting, so cascade does not apply.
		 */
		public void addSupplier (Supplier supplier) {
			if(!suppliers.contains(supplier)) {
				getSuppliers().add(supplier);
				supplier.getProducts().add(this);
			}
		}
		
		public void removeSupplier (Supplier supplier) {
			if(suppliers.contains(supplier)) {
				getSuppliers().remove(supplier);
				if(supplier.getProducts().contains(this)){
					supplier.getProducts().remove(this);
				}
			}
		}
		
		
		
		/* Methods for detaching  the product from the 
		 * order, adding another product or setting it to null.
		 * Use before deleting, so cascade does not apply.
		 */
		public void addOrder (Order order) {
			if(!orders.contains(order)) {
				getOrders().add(order);
				order.getProducts().add(this);
			}
		}
		
		public void removeOrder (Order order) {
			if(orders.contains(order)) {
				getOrders().remove(order);
				if(order.getProducts().contains(this)){
					order.getProducts().remove(this);
				}
			}
		}
		
		
}
