package com.stockagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stockagent.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@PostMapping("/search")
	public ModelAndView searchProduct(@ModelAttribute("name") String name) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product-list");
		mav.addObject("products", searchService.searchProduct(name));
		return mav;

	}

	

}
