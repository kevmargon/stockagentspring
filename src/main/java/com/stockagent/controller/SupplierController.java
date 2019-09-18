package com.stockagent.controller;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stockagent.service.SupplierService;
import com.stockagent.model.Direction;
import com.stockagent.model.Supplier;
import com.stockagent.model.Product;
import com.stockagent.repository.DirectionRepository;
import com.stockagent.repository.SupplierRepository;
import com.stockagent.repository.ProductRepository;

@Controller
public class SupplierController {
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private DirectionRepository directionRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
//	I declare 'notification' and 'notificationLabel' as class variables so that they are easy to 
//	share and pass through one method to the other (from the Post method for saving products and the Get for deleting
//	to the Get for showing the list products (getAllProducts)...
	
	public String notification = null; 
	public String notificationLabel = null; 
	
	/**
	 * Application enter point. URL will enter here and redirect the corresponding method.
	 * 
	 * @return
	 */
	@GetMapping("/suppliers")
	public String root() {
		return "redirect:/suppliers/list";
	}
	
	@GetMapping("/suppliers/list")
	public ModelAndView getAllSuppliers() {
		log.debug("request to get Suppliers");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("supplier-list");
		mav.addObject("suppliers", supplierService.findAll());
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}

	@GetMapping("/suppliers/empty")
	public ModelAndView createSupplier() {
		log.debug("request to empty supplier form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("supplier-edit");
		// Same jsp view form file for editing a supplier and inserting a new one.
		mav.addObject("supplier", new Supplier());
		//mav.addObject("direction", new Direction());
		mav.addObject("directions", directionRepository.findAll()); 
		//Adds the list of suppliers to the form
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * GET /suppliers/:id : get the "id" supplier.
	 *
	 * @param id the id of the supplier to retrieve
	 * @return
	 */
	@GetMapping("/suppliers/{id}")
	public ModelAndView getSupplier(@PathVariable Long id) {
		log.debug("request to get Supplier : {}", id);
		Optional<Supplier> supplier = supplierService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (supplier.isPresent()) {
			mav.setViewName("supplier-edit");
			mav.addObject("supplier", supplier.get());
			mav.addObject("directions", directionRepository.findAll());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("supplier-list");
			mav.addObject("message", "Supplier not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}

	/**
	 * GET /suppliers/:id : get the "id" supplier.
	 *
	 * @param id the id of the supplier to retrieve
	 * @return
	 */
	@GetMapping("/suppliers/{id}/detail")
	public ModelAndView seeProduct(@PathVariable Long id) {
		log.debug("request to get Supplier : {}", id);
		Optional<Supplier> supplier = supplierService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (supplier.isPresent()) {
			mav.setViewName("supplier-detail");
			mav.addObject("supplier", supplier.get());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("supplier-list");
			mav.addObject("message", "Supplier not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}
	
	/**
	 * POST /suppliers
	 *
	 * @ModelAttribute supplier : Data of the object (javaBean/Entity) supplier to save
	 * @return
	 */
	
	@PostMapping("/suppliers")
	public String saveSupplier(@ModelAttribute("supplier") Supplier supplier, @ModelAttribute("direction") Direction direction) {
		log.debug("request to save Supplier : {}", supplier);

		// CASE 1: The supplier does not exist and must be created.
		if (supplier.getId() == null) {
			if(supplierService.save(supplier)!=null) {
				notification = "A new supplier has been saved succesfully!";
				notificationLabel = "success";
			} else {
				notification = "ERROR. The supplier could not be saved succesfully.";
				notificationLabel = "error";
			}
			return "redirect:/suppliers";
		}

		// CASE 2: The supplier already exists and must be updated.
		Optional<Supplier> existingSupplierWrap = supplierService.findOne(supplier.getId());
		//Optional<Direction> existingDirectionWrap = directionService.findOne(direction.getId()); 
		//The commented line is not necessary as the supplier already contains the direction data (onetoOne relashionship)
		
		if (existingSupplierWrap.isPresent()) {

			Supplier existingSupplier = existingSupplierWrap.get();

			existingSupplier.setName(supplier.getName());
	
	
			//existingDirection.setDirection(existingDirection);
			//The commented line is not necessary as the supplier already contains the direction data
			if(supplierService.save(existingSupplier)!=null) {
				notification = "The supplier has been updated succesfully!";
				notificationLabel = "success";
			
			} else {
				notification = "ERROR. The supplier could not be updated succesfully.";
				notificationLabel = "error";
			}
		}
		return "redirect:/suppliers";
	}

	/**
	 * GET /suppliers/:id/delete : delete the "id" supplier.
	 *
	 * @param id the id of the supplier to delete
	 * @return
	 */
	@GetMapping("/suppliers/{id}/delete")
	public String deleteSupplier(@PathVariable Long id) {
		log.debug("request to delete Supplier : {}", id);
		
			
//		List<Product> products= productRepository.findBySupplierId(id);
////		Searches and selects the list of products of a certain supplier,and store it on 'products'
//		for (Product product : products) {
//			product.setSupplier(null);
//			productRepository.save(product);
//		}
//		The loop detaches the supplier and set it to null for each product of the resultant list products.
//		That allows removing the supplier, without removing all the associated products.
		

		supplierService.delete(id);
		notification = "The supplier has been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/suppliers" ;
	}
	@GetMapping("/suppliers/{id}/deleteAll")
	public String deleteProductsSupplier(@PathVariable Long id) {
		log.debug("request to delete Supplier : {}", id);
		
		supplierService.delete(id);
		notification = "The supplier and all the associated products have been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/suppliers" ;
	}
	
	
//	@DeleteMapping("/suppliers/{id}/delete2")
//    public String delete(@PathVariable Long id) {
//        return "redirect:/suppliers";
//    }
}
