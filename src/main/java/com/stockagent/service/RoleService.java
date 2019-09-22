package com.stockagent.service;
import java.util.List;
import java.util.Optional;

import com.stockagent.model.Role;
/**
 * Service Interface for managing Role.
 */
public interface RoleService{
	/**
	 * Save a role
	 * @param role
	 * @return
	 */
	Role save(Role role);
	
	/**
	 * Get all roles
	 * @return
	 */
	List<Role> findAll();
	
	/**
	 * Get one role by id
	 * @param id
	 * @return
	 */
	Optional<Role> findOne(Long id);
	
	/**
	 * It deletes one role by id
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Get list of roles by employee id
	 * @param id
	 * @return
	 */
	List<Role> findRoleByEmployeeId(Long id);
	


}
