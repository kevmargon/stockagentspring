package com.stockagent;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stockagent.model.Category;
import com.stockagent.model.Customer;
import com.stockagent.model.Direction;
import com.stockagent.model.Employee;
import com.stockagent.model.Order;
import com.stockagent.model.Position;
import com.stockagent.model.Product;
import com.stockagent.model.Report;
import com.stockagent.model.Supplier;
import com.stockagent.repository.CategoryRepository;
import com.stockagent.repository.CustomerRepository;
import com.stockagent.repository.DirectionRepository;
import com.stockagent.repository.EmployeeRepository;
import com.stockagent.repository.OrderRepository;
import com.stockagent.repository.PositionRepository;
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
	private PositionRepository positionRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
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
		Customer cus1 = new Customer("Juan","Martinez","Perez","75486523F",658457123);
		dir1 = new Direction("Calle Zumalacárregui",18,24008,"Palencia","Palencia","Spain");
		dir1.setCustomer(cus1);
		cus1.setDirection(dir1);
		directionRepository.save(dir1);
		customerRepository.save(cus1);
		
		//Foreign key declaration & save Category - Product // Supplier - Product
		Category cat1 = categoryRepository.save(new Category("Abrigos"));		
		Product pro1 = new Product("Abrigo Lisboa Rojo",new BigDecimal(70),20,"Adidas");
		pro1.setCategory(cat1);
		Supplier sup1 = new Supplier("Inditex");
		pro1.getSuppliers().add(sup1);
		sup1.getProducts().add(pro1);
		supplierRepository.save(sup1);
		categoryRepository.save(cat1);
		productRepository.save(pro1);

		//Foreign key declaration & save Employee - Direction // Employee - Report // Employee - Position
		Employee emp1 = new Employee("stromae","1234","Francisco","Celada","Prado","75213521C",655232156);
		Direction dir2 = new Direction("Avenida Independencia",22,24001,"León","León","Spain");
		emp1.setDirection(dir2);
		Report rep1 = reportRepository.save(new Report("Esto es una prueba de informe",report.getDateTime()));
		rep1.setEmployee(emp1);
		employeeRepository.save(emp1);
		reportRepository.save(rep1);
		
		//Foreign key declaration & save Orders - Employee // Orders - Customers
		Order ord1 = new Order(order.getSellDate(),new BigDecimal(30),10);
		ord1.setEmployee(emp1);
		ord1.setCustomers(cus1);
		orderRepository.save(ord1);
		
		//Foreign key declaration & save Employee - Position
		Position pos1 = new Position("Admin");
		pos1.getEmployees().add(emp1);
		emp1.getPositions().add(pos1);
		positionRepository.save(pos1);
		employeeRepository.save(emp1);

		//Foreign key declaration & save Product - Order
		pro1.getOrders().add(ord1);
		ord1.getProducts().add(pro1);
		orderRepository.save(ord1);
		productRepository.save(pro1);
		
		//cus1.getOrder().add(ord1);
		
		//categoryRepository.delete(cat1);
	}
	
	

}
