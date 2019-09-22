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

import com.stockagent.model.Direction;
import com.stockagent.model.Employee;
import com.stockagent.model.Role;
import com.stockagent.repository.RoleRepository;
import com.stockagent.service.EmployeeService;
import com.stockagent.service.RoleService;

@Controller
public class EmployeeController {
//	Object Logger for logging (recording) messages for easier actions and errors tracking
	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	
//	I declare 'notification' and 'notificationLabel' as class variables so that they are easy to 
//	share and pass through one method to the other (from the Post method for saving roles and the Get for deleting
//	to the Get for showing the list roles (getAllRoles)...
	
	public String notification = null; 
	public String notificationLabel = null; 
	
	/**
	 * Application enter point. URL will enter here and redirect the corresponding method.
	 * 
	 * @return
	 */
	@GetMapping("/employees")
	public String root() {
		return "redirect:/employees/list";
	}
	
	@GetMapping("/employees/list")
	public ModelAndView getAllEmployees() {
		log.debug("request to get Employees");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee-list");
		mav.addObject("employees", employeeService.findAll());
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}

	@GetMapping("/employees/empty")
	public ModelAndView createEmployee() {
		log.debug("request to empty employee form");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee-edit");
		// Same jsp view form file for editing a employee and inserting a new one.
		mav.addObject("employee", new Employee());
		//mav.addObject("role", new Direction());
		mav.addObject("roles", roleRepository.findAll()); 
		//Adds the list of roles to the form
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * GET /employees/:id : get the "id" employee.
	 *
	 * @param id the id of the employee to retrieve
	 * @return
	 */
	@GetMapping("/employees/{id}")
	public ModelAndView getEmployee(@PathVariable Long id) {
		log.debug("request to get Employee : {}", id);
		Optional<Employee> employee = employeeService.findOne(id);

		ModelAndView mav = new ModelAndView();
		if (employee.isPresent()) {
			mav.setViewName("employee-edit");
			mav.addObject("employee", employee.get());
			mav.addObject("roles", roleRepository.findAll());
			notification = null;
			notificationLabel = null;
		} else {
			mav.setViewName("employee-list");
			mav.addObject("message", "Employee not found");
			notification = null;
			notificationLabel = null;
		}

		return mav;
	}

	/**
	 * GET /employees/:id : get the "id" employee.
	 *
	 * @param id the id of the employee to retrieve
	 * @return
	 */
	@GetMapping("/employees/{id}/detail")
	public ModelAndView seeRole(@PathVariable Long id) {
		log.debug("request to get Employee : {}", id);
		Optional<Employee> employee = employeeService.findOne(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee-detail"); //roles-by-employee-list
		mav.addObject("employee", employee.get());
		mav.addObject("roles", roleService.findRoleByEmployeeId(id));
		mav.addObject("notification", notification );
		mav.addObject("notificationLabel", notificationLabel );
		notification = null;
		notificationLabel = null;
		return mav;
	}
	
	/**
	 * POST /employees
	 *
	 * @ModelAttribute employee : Data of the object (javaBean/Entity) employee to save
	 * @return
	 */
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("direction") Direction direction) {
		log.debug("request to save Employee : {}", employee);

		// CASE 1: The employee does not exist and must be created.
		if (employee.getId() == null) {
			if(employeeService.save(employee)!=null) {
				notification = "A new employee has been saved succesfully!";
				notificationLabel = "success";
			} else {
				notification = "ERROR. The employee could not be saved succesfully.";
				notificationLabel = "error";
			}
			return "redirect:/employees";
		}

		// CASE 2: The employee already exists and must be updated.
		Optional<Employee> existingEmployeeWrap = employeeService.findOne(employee.getId());
		//Optional<Direction> existingDirectionWrap = directionService.findOne(direction.getId()); 
		//The commented line is not necessary as the employee already contains the direction data (onetoOne relashionship)
		
		if (existingEmployeeWrap.isPresent()) {

			Employee existingEmployee = existingEmployeeWrap.get();

			existingEmployee.setName(employee.getName());

			//existingDirection.setDirection(existingDirection);
			//The commented line is not necessary as the employee already contains the direction data
			if(employeeService.save(existingEmployee)!=null) {
				notification = "The employee has been updated succesfully!";
				notificationLabel = "success";
			
			} else {
				notification = "ERROR. The employee could not be updated succesfully.";
				notificationLabel = "error";
			}
		}
		return "redirect:/employees";
	}

	/**
	 * GET /employees/:id/delete : delete the "id" employee.
	 *
	 * @param id the id of the employee to delete
	 * @return
	 */
//	@GetMapping("/employees/{id}/delete")
//	public String deleteEmployee(@PathVariable Long id) {
//		log.debug("request to delete Employee : {}", id);
//
//		List<Role> roles = roleRepository.findByEmployeeId(id);
////		Searches and selects the list of roles of a certain employee,and store it on 'roles'
//		for (Role role : roles) {
//			role.setEmployee(null);
//			roleRepository.save(role);
//		}
////		The loop detaches the employee and set it to null for each role of the resultant list roles.
////		That allows removing the employee, without removing all the associated roles.
//
//		employeeService.delete(id);
//		notification = "The employee has been deleted succesfully!";
//		notificationLabel = "success";
//		return "redirect:/employees";
//	}
	
	@GetMapping("/employees/{id}/delete")
	public String deleteRolesEmployee(@PathVariable Long id) {
		log.debug("request to delete Employee : {}", id);
		
		employeeService.delete(id);
		notification = "The employee has been deleted succesfully!";
		notificationLabel = "success";
		return "redirect:/employees" ;
	}
	
	
//	@DeleteMapping("/employees/{id}/delete2")
//    public String delete(@PathVariable Long id) {
//        return "redirect:/employees";
//    }
}
