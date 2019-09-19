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
		log.debug("request to get log in");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login-form");
		//Optional<Employee> employee;// = new Employee();
		//mav.addObject("employee", employee.get());
		mav.addObject("employee", new Employee());
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("contra");

		boolean isError = false;
		if (usuario == null || usuario.length() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletError");
			dispatcher.forward(request, response);
			// out.println("<b>Nombre</b> iválido");
			isError = true;
			return;

		}
		if (contra == null || contra.length() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletError");
			dispatcher.forward(request, response);
			// out.println("<br><b>Apellido</b> iválido");
			isError = true;
			return;

		}
		if (!isError) {
			try {
				boolean res = Metodos.validaCampos(usuario, contra);
				if (res) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletSuccUser");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletErrUser");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
	
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
