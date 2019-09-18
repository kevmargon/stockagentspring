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

import com.stockagent.service.DirectionService;
import com.stockagent.model.Direction;

@Controller
public class DirectionController {
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(DirectionController.class);
	
	@Autowired
	private DirectionService directionService;
	
	
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
	@GetMapping("/directions")
	public String root() {
		return "redirect:/directions/list";
	}
	
	@GetMapping("/directions/list")
	public ModelAndView getAllDirections() {
		log.debug("request to get Directions");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("direction-list");
		mav.addObject("directions", directionService.findAll());
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}

	@GetMapping("/directions/empty")
	public ModelAndView createDirection() {
		log.debug("request to empty direction form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("direction-edit");// Same jsp view form file for editing a direction and inserting a new one.
		mav.addObject("direction", new Direction());
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * GET /directions/:id : get the "id" direction.
	 *
	 * @param id the id of the direction to retrieve
	 * @return
	 */
	@GetMapping("/directions/{id}")
	public ModelAndView getDirection(@PathVariable Long id) {
		log.debug("request to get Direction : {}", id);
		Optional<Direction> direction = directionService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (direction.isPresent()) {
			mav.setViewName("direction-edit");
			mav.addObject("direction", direction.get());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("direction-list");
			mav.addObject("message", "Direction not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}

	/**
	 * POST /directions 
	 *
	 * @ModelAttribute direction : Data of the object (javaBean/Entity) direction to save
	 * @return
	 */
	@PostMapping("/directions")
	public String saveDirection(@ModelAttribute("direction") Direction direction) {
		log.debug("request to save Direction : {}", direction);

//		CASE 1: The direction does not exist and must be created.
		if (direction.getId() == null) {
			if(directionService.save(direction)!=null) {
				notification = "A new direction has been saved succesfully!";
				notificationLabel = "success";
			} else {
				notification = "ERROR. The direction could not be saved succesfully.";
				notificationLabel = "error";
			}
			return "redirect:/directions";
		}

//		CASE 2:  The direction already exists and must be updated.
		Optional<Direction> existingDirectionWrap = directionService.findOne(direction.getId());
		if (existingDirectionWrap.isPresent()) {

			Direction existingDirection = existingDirectionWrap.get();
			existingDirection.setAddress(direction.getAddress());
			existingDirection.setHouseNumber(direction.getHouseNumber());
			existingDirection.setZipCode(direction.getZipCode());
			existingDirection.setCity(direction.getCity());
			existingDirection.setProvince(direction.getProvince());
			existingDirection.setCountry(direction.getCountry());
			if(directionService.save(existingDirection)!=null) {;
			 	notification = "The direction has been updated succesfully!";
			 	notificationLabel = "success";
			
			} else {
				notification = "ERROR. The direction could not be updated succesfully.";
				notificationLabel = "error";
			
			}
		}
		return "redirect:/directions";
	}

	/**
	 * /directions/:id/delete : delete the "id" direction.
	 *
	 * @param id the id of the direction to delete
	 * @return
	 */
	@GetMapping("/directions/{id}/delete")
	public String deleteDirection(@PathVariable Long id) {
		log.debug("request to delete Direction : {}", id);
		directionService.delete(id);
		return "redirect:/directions" ;
	}

}
