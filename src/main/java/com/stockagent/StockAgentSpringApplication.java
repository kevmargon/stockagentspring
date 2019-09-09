package com.stockagent;

import java.math.BigDecimal;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stockagent.model.Category;
import com.stockagent.model.Customer;
import com.stockagent.model.Direction;
import com.stockagent.model.Employee;
import com.stockagent.model.Order;
import com.stockagent.model.Role;
import com.stockagent.model.Product;
import com.stockagent.model.Report;
import com.stockagent.model.Supplier;
import com.stockagent.repository.CategoryRepository;
import com.stockagent.repository.CustomerRepository;
import com.stockagent.repository.DirectionRepository;
import com.stockagent.repository.EmployeeRepository;
import com.stockagent.repository.OrderRepository;
import com.stockagent.repository.RoleRepository;
import com.stockagent.repository.ProductRepository;
import com.stockagent.repository.ReportRepository;
import com.stockagent.repository.SupplierRepository;

@SpringBootApplication
public class StockAgentSpringApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DirectionRepository directionRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Employee employee = null;
	
	public static void main(String[] args) {
		SpringApplication.run(StockAgentSpringApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		//Object order created for date storage
				Date nowdateorder = Date.from(Instant.now());
				Order order = new Order();
				order.setSellDate(new Date());
				
				try {
					order.setSellDate(nowdateorder);
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
		//Object order created for date storage
				Date nowdatereport = Date.from(Instant.now());
				Report report = new Report();
				report.setDateTime(new Date());
				
				try {
					report.setDateTime(nowdatereport);
				}catch(Exception ex){
					ex.printStackTrace();
				}
		//Foreign key declaration & save Direction - Customer
		Direction dir1 = new Direction();
		Customer cus1 = new Customer("Juan","Martinez","Perez","75486523F","658457123");
		dir1 = new Direction("Calle Zumalacárregui",18,24008,"Palencia","Palencia","Spain");
		
		cus1.addDirection(dir1);
		//dir1.setCustomer(cus1);
		//cus1.setDirection(dir1);
		directionRepository.save(dir1);
		customerRepository.save(cus1);
		
		Direction dir2 = new Direction();
		Customer cus2 = new Customer("Enrique","Matilla","Lorenzana","75213230B","689542125");
		dir2 = new Direction("Calle Rosales",25,21082,"Soria","Soria","Spain");
		
		cus2.addDirection(dir2);
		//dir2.setCustomer(cus2);
		//cus2.setDirection(dir2);
		directionRepository.save(dir2);
		customerRepository.save(cus2);

		Direction dir3 = new Direction();
		Customer cus3 = new Customer("Sara","Prieto","Alonso","72345124G","695642158");
		dir3 = new Direction("Calle Real",2,22059,"Madrid","Madrid","Spain");
		
		cus3.addDirection(dir3);
		//dir3.setCustomer(cus3);
		//cus3.setDirection(dir3);
		directionRepository.save(dir3);
		customerRepository.save(cus3);
		
		
		//Foreign key declaration & save Category - Product // Supplier - Product
		Category cat1 = categoryRepository.save(new Category("Abrigos"));		
		Product pro1 = new Product("Abrigo Lisboa Rojo",new BigDecimal(70),20,"Adidas");
		//pro1.setCategory(cat1);
		Supplier sup1 = new Supplier("Inditex");
		
		cat1.addProduct(pro1);
		pro1.addSupplier (sup1);
		//pro1.getSuppliers().add(sup1);
		//sup1.getProducts().add(pro1);
		supplierRepository.save(sup1);
		categoryRepository.save(cat1);
		productRepository.save(pro1);
		
		
		Category cat2 = categoryRepository.save(new Category("Pantalones"));		
		Product pro2 = new Product("Pantalón Beige Luna",new BigDecimal(30),15,"Mango");
		//pro2.setCategory(cat2);
		Supplier sup2 = new Supplier("Desigual");
		
		cat2.addProduct(pro2);
		pro2.addSupplier (sup2);
		//pro2.getSuppliers().add(sup2);
		//sup2.getProducts().add(pro2);
		supplierRepository.save(sup2);
		categoryRepository.save(cat2);
		productRepository.save(pro2);

		Category cat3 = categoryRepository.save(new Category("Camisas"));		
		Product pro3 = new Product("Camiseta Azul Cielo",new BigDecimal(25),25,"Adidas");
		
		cat2.addProduct(pro2);
		//pro3.setCategory(cat3);
		Supplier sup3 = new Supplier("Dassler");
		
		pro3.addSupplier (sup3);
		//pro3.getSuppliers().add(sup3);
		//sup3.getProducts().add(pro3);
		supplierRepository.save(sup3);
		categoryRepository.save(cat3);
		productRepository.save(pro3);
		

		//Foreign key declaration & save Employee - Direction // Employee - Report // Employee - Position
		Employee emp1 = new Employee("stromae","1234","Francisco","Celada","Prado","75213521C","655232156");
		Direction dir4 = new Direction("Avenida Independencia",22,24001,"León","León","Spain");
		
		emp1.addDirection (dir4);
		//emp1.addDirection (dir4);
		//emp1.setDirection(dir4);
		Report rep1 = reportRepository.save(new Report("Esto es una prueba de informe",report.getDateTime()));
		
		rep1.addEmployee(emp1);
		//rep1.setEmployee(emp1);
		employeeRepository.save(emp1);
		reportRepository.save(rep1);
		
		
		Employee emp2 = new Employee("sadia","4321","Ismael","Rodríguez","de la Moral","76521223Y","685954213");
		Direction dir5 = new Direction("Calle Teredia",31,24001,"León","León","Spain");
		
		emp2.addDirection (dir5);
		//emp2.setDirection(dir5);
		Report rep2 = reportRepository.save(new Report("Esto es una segunda prueba de informe",report.getDateTime()));
		
		rep2.addEmployee(emp2);
		//rep2.setEmployee(emp2);
		employeeRepository.save(emp2);
		reportRepository.save(rep2);

		Employee emp3 = new Employee("azulen","2314","Carmen","Fuentes","Pérez","75213235D","685200121");
		Direction dir6 = new Direction("Avenida Sagrada",1,24001,"León","León","Spain");
		
		emp3.addDirection (dir6);
		//emp3.setDirection(dir6);
		Report rep3 = reportRepository.save(new Report("Esto es una tercera prueba de informe",report.getDateTime()));
		
		rep3.addEmployee(emp3);
		//rep3.setEmployee(emp3);
		employeeRepository.save(emp3);
		reportRepository.save(rep3);
		
		//Foreign key declaration & save Order - Employee // Order - Customers// Product - Order
		Order ord1 = new Order(order.getSellDate(),pro1.getPrice(),1);
		pro1.addOrder(ord1);
		emp1.addOrder (ord1);
		cus1.addOrder (ord1);//Tb debemos añadir la orden a customer
		//ord1.setEmployee(emp1);
		//ord1.setCustomer(cus1);
		orderRepository.save(ord1);
		productRepository.save(pro1);
		employeeRepository.save(emp1);
		
		Order ord2 = new Order(order.getSellDate(),pro2.getPrice(),1);
		pro2.addOrder(ord2);
		emp2.addOrder (ord2);
		cus2.addOrder (ord2);
		//ord2.setEmployee(emp2);
		//ord2.setCustomer(cus2);
		orderRepository.save(ord2);
		productRepository.save(pro2);
		employeeRepository.save(emp2);

		Order ord3 = new Order(order.getSellDate(),pro3.getPrice(),1);
		pro3.addOrder(ord3);
		emp3.addOrder (ord3);
		cus3.addOrder (ord3);
		//ord3.setEmployee(emp3);
		//ord3.setCustomer(cus3);
		orderRepository.save(ord3);
		productRepository.save(pro3);
		employeeRepository.save(emp3);
		
		//Foreign key declaration & save Employee - Role
		Role rol1 = new Role("Admin");
		emp1.addRole (rol1);
		//rol1.getEmployees().add(emp1);
		//emp1.getRoles().add(rol1);
		roleRepository.save(rol1);
		employeeRepository.save(emp1);
		
		Role rol2 = new Role("Moderator");
		emp2.addRole (rol2);
		//rol2.getEmployees().add(emp2);
		//emp2.getRoles().add(rol2);
		roleRepository.save(rol2);
		employeeRepository.save(emp2);

		Role rol3 = new Role("User");
		emp3.addRole (rol3);
		//rol3.getEmployees().add(emp3);
		//emp3.getRoles().add(rol3);
		roleRepository.save(rol3);
		employeeRepository.save(emp3);

		

		

	
		//The product must be detached from the category before deleting such, if the product is wanted to stay in the database.
		//REV-M --OJO: Habría que desvincular el producto si se quiere eliminar la categoria como sigue
		List<Product> prods = new ArrayList<>();
		prods = cat1.getProducts();
		for(Product p: prods) {
			cat1.removeProduct (p);
		}
		//cat1.removeProduct (pro1); // solo desvincularia pro1
		categoryRepository.delete(cat1);
	}
	
	
	
	

}
