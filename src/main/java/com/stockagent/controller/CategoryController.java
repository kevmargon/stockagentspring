package com.stockagent.controller;

import java.util.List;
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

import com.stockagent.model.Category;
import com.stockagent.model.Direction;
import com.stockagent.model.Product;
import com.stockagent.repository.CategoryRepository;
import com.stockagent.repository.DirectionRepository;
import com.stockagent.repository.ProductRepository;
import com.stockagent.service.CategoryService;
import com.stockagent.service.ProductService;

@Controller
public class CategoryController {
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
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
	@GetMapping("/categories")
	public String root() {
		return "redirect:/categories/list";
	}
	
	@GetMapping("/categories/list")
	public ModelAndView getAllCategories() {
		log.debug("request to get Categories");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("category-list");
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}

	@GetMapping("/categories/empty")
	public ModelAndView createCategory() {
		log.debug("request to empty category form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("category-edit");
		// Same jsp view form file for editing a category and inserting a new one.
		mav.addObject("category", new Category());
		//mav.addObject("product", new Direction());
		//mav.addObject("products", productRepository.findAll()); 
		//Adds the list of products to the form
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * GET /categories/:id : get the "id" category.
	 *
	 * @param id the id of the category to retrieve
	 * @return
	 */
	@GetMapping("/categories/{id}")
	public ModelAndView getCategory(@PathVariable Long id) {
		log.debug("request to get Category : {}", id);
		Optional<Category> category = categoryService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (category.isPresent()) {
			mav.setViewName("category-edit");
			mav.addObject("category", category.get());
			//mav.addObject("products", productRepository.findAll());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("category-list");
			mav.addObject("message", "Category not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}

	/**
	 * GET /categories/:id : get the "id" category.
	 *
	 * @param id the id of the category to retrieve
	 * @return
	 */
	@GetMapping("/categories/{id}/detail")
	public ModelAndView seeProduct(@PathVariable Long id) {
		log.debug("request to get Category : {}", id);
		Optional<Category> category = categoryService.findOne(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("category-detail"); //products-by-category-list
		mav.addObject("category", category.get());
		mav.addObject("products", productService.findProductByCategoryId(id));
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * POST /categories
	 *
	 * @ModelAttribute category : Data of the object (javaBean/Entity) category to save
	 * @return
	 */
	
	@PostMapping("/categories")
	public String saveCategory(@ModelAttribute("category") Category category, @ModelAttribute("direction") Direction direction) {
		log.debug("request to save Category : {}", category);

		// CASE 1: The category does not exist and must be created.
		if (category.getId() == null) {
			if(categoryService.save(category)!=null) {
				notification = "A new category has been saved succesfully!";
				notificationLabel = "success";
			} else {
				notification = "ERROR. The category could not be saved succesfully.";
				notificationLabel = "error";
			}
			return "redirect:/categories";
		}

		// CASE 2: The category already exists and must be updated.
		Optional<Category> existingCategoryWrap = categoryService.findOne(category.getId());
		//Optional<Direction> existingDirectionWrap = directionService.findOne(direction.getId()); 
		//The commented line is not necessary as the category already contains the direction data (onetoOne relashionship)
		
		if (existingCategoryWrap.isPresent()) {

			Category existingCategory = existingCategoryWrap.get();

			existingCategory.setName(category.getName());

			//existingDirection.setDirection(existingDirection);
			//The commented line is not necessary as the category already contains the direction data
			if(categoryService.save(existingCategory)!=null) {
				notification = "The category has been updated succesfully!";
				notificationLabel = "success";
			
			} else {
				notification = "ERROR. The category could not be updated succesfully.";
				notificationLabel = "error";
			}
		}
		return "redirect:/categories";
	}

	/**
	 * GET /categories/:id/delete : delete the "id" category.
	 *
	 * @param id the id of the category to delete
	 * @return
	 */
	@GetMapping("/categories/{id}/delete")
	public String deleteCategory(@PathVariable Long id) {
		log.debug("request to delete Category : {}", id);
		
			
		List<Product> products= productRepository.findByCategoryId(id);
//		Searches and selects the list of products of a certain category,and store it on 'products'
		for (Product product : products) {
			product.setCategory(null);
			productRepository.save(product);
		}
//		The loop detaches the category and set it to null for each product of the resultant list products.
//		That allows removing the category, without removing all the associated products.
		

		categoryService.delete(id);
		notification = "The category has been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/categories" ;
	}
	@GetMapping("/categories/{id}/deleteAll")
	public String deleteProductsCategory(@PathVariable Long id) {
		log.debug("request to delete Category : {}", id);
		
		categoryService.delete(id);
		notification = "The category and all the associated products have been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/categories" ;
	}
	
	
//	@DeleteMapping("/categories/{id}/delete2")
//    public String delete(@PathVariable Long id) {
//        return "redirect:/categories";
//    }
}
