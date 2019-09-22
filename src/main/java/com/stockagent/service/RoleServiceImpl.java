package com.stockagent.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Role;
import com.stockagent.repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService {
	private final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role save(Role role) {
		 log.debug("Request to save Role : {}", role);
	     return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		log.debug("Request to get all Roles");
        return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findOne(Long id) {
		log.debug("Request to get Role : {}", id);
        return roleRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Role : {}", id);
        roleRepository.deleteById(id);
	}

	@Override
	public List<Role> findRoleByEmployeeId(Long id) {
		  log.debug("Request to find the list of Roles from a Employee : {}", id);
  		return roleRepository.findByEmployeeId(id);
	}




}
