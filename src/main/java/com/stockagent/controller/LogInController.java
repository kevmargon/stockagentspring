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

import com.stockagent.model.Employee;
import com.stockagent.model.Product;
import com.stockagent.repository.EmployeeRepository;
import com.stockagent.service.LogInService;


@Controller
public class LogInController{
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private LogInService loginService;
	
	public String notification = null; 
	public String notificationLabel = null; 

	/**
	 * Application enter point. URL will enter here and redirect the corresponding method.
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String root() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public ModelAndView getLogin() {
		String user = null;
		String pass = null;
		log.debug("request to get log in");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login-form");
		mav.addObject("user", user);
		mav.addObject("pass", pass);		
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	
	@PostMapping("/login")
	public String findUser(@ModelAttribute("user") String user, @ModelAttribute("pass") String pass ) {
		log.debug("request to check User (employee) : {}", user, pass);
		System.out.println(user);
		System.out.println(pass);
			
		try {
			boolean result= loginService.userConnection (loginService.encriptsha1(user), loginService.encriptsha1(pass));
//			boolean result= loginService.userConnection (loginService.encriptsha1("stromae"), loginService.encriptsha1("1234"));
			if (result == false) {
				System.out.println("=================================== HOLA BILLY2");
				notification = "Error. User name or password are incorrect.";
				notificationLabel = "success";
				return "redirect:/login";
				
			} else if (result) {
				//notification = "Bienvenido"+employee.getName();///????????????
				notificationLabel = "success";
				return "redirect:/products";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "redirect:/login";
		}
		return "redirect:/login";
	}
}
