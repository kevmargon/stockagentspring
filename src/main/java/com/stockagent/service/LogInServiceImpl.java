package com.stockagent.service;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Employee;
import com.stockagent.model.Role;
import com.stockagent.repository.EmployeeRepository;

@Service
public class LogInServiceImpl implements LogInService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public boolean userConnection(String user, String pass) {
		
		List<Employee> employees= employeeRepository.findByUserAndPass(user, pass);
//		Searches and selects the employee with a centain user and password and
//		stores  it in a the list (that will have only one element)
		for (Employee e : employees) {
			Long idLogin = e.getId(); // SET AS SESSION ATTRIBUTE
			List <Role> roles = e.getRoles();// SET AS SESSION ATTRIBUTE
//			System.out.print(e.getId() + " === ");
//			System.out.print(e.getUser() + " === ");
//			System.out.println(e.getPass() + " === ");
		}
		if (employees.size() == 0) {
			Boolean Login = false; // SET AS SESSION ATTRIBUTE
			return false;
		} else {
			Boolean Login = true;// SET AS SESSION ATTRIBUTE
			return true;
		}
	}
	@Override
	public String encriptsha1(String var) {
		try {
			// getInstance() method is called with algorithm SHA-1
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(var.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			// return the HashText
		return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String autogenerateUser(String name) {
		String username = null;
		boolean repeted;
		int i = 1;
		do {
			username = username.replaceAll("\\s",""); //Remove blank spaces
			if (username.length()>4) {
				username = username.substring(0,3);
			}
			StringBuilder builder = new StringBuilder();
			// Concatenate
			builder.append(username);
			builder.append("#");
			builder.append(i);
			username = builder.toString();
			repeted = checkRepetedUserName(username);
			i++;
		}while (repeted == true);
		System.out.print("The user name generated is:" + username);
		return username;
	}
	
	@Override
	public String autogeneratePass() {
		String pass = "";
		Random rnd = new Random();
		pass+= (char)(rnd.nextInt(91) + 65);
		pass+= (rnd.nextInt(9999) + 1000);
		System.out.print("The generated password is:" + pass);
		return pass;
	}
	
	@Override
	public boolean checkRepetedUserName(String username) {
		boolean repeted;
		List<Employee> employees= employeeRepository.findByUser(username);
//		Searches and selects the employee with a centain user and
//		stores  it in a the list (that will have only one element)
		if (employees.size() == 0) {
			repeted = false;	
		} else {
			repeted = true; // there is another employee in the database with the same user name
		}
		return repeted;
	}
	
}
