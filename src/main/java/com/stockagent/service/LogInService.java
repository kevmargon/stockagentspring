package com.stockagent.service;
import java.util.List;


import java.util.Optional;

import com.stockagent.model.Product;
/**
 * Service Interface for managing Product.
 */
public interface LogInService{
	/**
	 * Check the connection from the log-in
	 * @param user
	 * @param pass
	 * @return
	 */
	boolean userConnection(String user, String pass);
	
	/**
	 * Get a String variable var and encript it with SHA1 method
	 * @return 
	 */
	String encriptsha1(String var);
	
	/**
	 * Generates a ramdom user name based on the employee name, that must not exist on the DB already
	 * @param name: name of the employee
	 * @return
	 */
	String autogenerateUser(String name);
	
	/**
	 * Generates a ramdom user password
	 * @return
	 */
	String autogeneratePass();
	
	/**
	 * Checks if the username already exits in the database (it must be unique)
	 * @return
	 */
	boolean checkRepetedUserName(String username);


	
}
