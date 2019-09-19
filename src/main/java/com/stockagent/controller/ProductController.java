package com.stockagent.controller;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stockagent.model.Product;
import com.stockagent.repository.CategoryRepository;
import com.stockagent.repository.SupplierRepository;
import com.stockagent.service.ProductService;

@Controller
public class ProductController {
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	
//	I declare 'notification' and 'notificationLabel' as class variables so that they are easy to 
//	share and pass through one method to the other (from the Post method for saving products and the Get for deleting
//	to the Get for showing the list products (getAllProducts)...
	
	public String notification = null; 
	public String notificationLabel = null; 
	

	@GetMapping("/products")
	public String root() {
		return "redirect:/products/list";
	}
	
	@GetMapping("/products/list")
	public ModelAndView getAllProducts() {
		log.debug("request to get Products");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product-list");
		mav.addObject("products", productService.findAll());
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}

	@GetMapping("/products/empty")
	public ModelAndView createProduct() {
		log.debug("request to empty product form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product-edit");
//		The same jsp view file is used for the product editing form and  new product inserting one.
		mav.addObject("product", new Product());
		mav.addObject("categories", categoryRepository.findAll()); 
//		The upper line adds the whole list of categories to the form	
//		mav.addObject("suppliers", supplierRepository.findAll()); 
//		The upper line adds the whole list of suppliers to the form
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * GET /products/:id : get the "id" product.
	 *
	 * @param id the id of the product to retrieve
	 * @return
	 */
	@GetMapping("/products/{id}")
	public ModelAndView getProduct(@PathVariable Long id) {
		
		
		
		log.debug("request to get Product : {}", id);
		Optional<Product> product = productService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (product.isPresent()) {
			mav.setViewName("product-edit");
			mav.addObject("product", product.get());
			mav.addObject("categories", categoryRepository.findAll());
//			mav.addObject("suppliers", supplierRepository.findAll());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("product-list");
			mav.addObject("message", "Product not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}

	/**
	 * GET /products/:id : get the "id" product.
	 *
	 * @param id : the id of the product to retrieve
	 * @return
	 */
	@GetMapping("/products/{id}/detail")
	public ModelAndView seeProduct(@PathVariable Long id) {
		log.debug("request to get Product : {}", id);
		Optional<Product> product = productService.findOne(id);
	
		ModelAndView mav = new ModelAndView();
		if (product.isPresent()) {
			mav.setViewName("product-detail");
			mav.addObject("product", product.get());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("product-list");
			mav.addObject("message", "Product not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}
	
	/**
	 * POST /products 
	 *
	 * @ModelAttribute product : Data of the object (javaBean/Entity) product to save
	 * @return
	 */
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product) {
		log.debug("request to save Product : {}", product);
				
//		CASE 1: The product does not exist and must be created.
		if (product.getId() == null) {
			if(productService.save(product)!=null) {
				notification = "A new product has been saved succesfully!";
				notificationLabel = "success";
			} else {
				notification = "ERROR. The product could not be saved succesfully.";
				notificationLabel = "error";
			}
			return "redirect:/products";
		}

//		CASE 2:  The product already exists and must be updated.
		Optional<Product> existingProductWrap = productService.findOne(product.getId());
		if (existingProductWrap.isPresent()) {
			Product existingProduct = existingProductWrap.get();
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setAmount(product.getAmount());
			existingProduct.setManufacturer(product.getManufacturer());
			existingProduct.setCategory(product.getCategory());
//			List <Supplier> suppliers = product.getSuppliers();
//			for(Supplier supplier: suppliers) {
//				existingProduct.getSuppliers().add(supplier);
//			}
//			List <Order> orders = product.getOrders();
//			for(Order order: orders) {
//				existingProduct.getOrders().add(order);
//			}
				
				
			if(productService.save(existingProduct)!=null) {;
				 notification = "The product has been updated succesfully!";
				 notificationLabel = "success";
				
			} else {
				notification = "ERROR. The product could not be updated succesfully.";
				notificationLabel = "error";
				
			}
		}
		return "redirect:/products";
	}

	/**
	 * GET /products/:id/delete : delete the "id" product.
	 *
	 * @param id the id of the product to delete
	 * @return
	 */
	
	@GetMapping("/products/{id}/delete")
	public String deleteProduct(@PathVariable Long id) {
		log.debug("request to delete Product : {}", id);
		productService.delete(id);
		notification = "The product has been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/products" ;
	}

}

