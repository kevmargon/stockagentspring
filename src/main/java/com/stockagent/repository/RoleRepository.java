package com.stockagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stockagent.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}