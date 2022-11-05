package com.glearning.employees.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.glearning.employees.model.Employee;
import com.glearning.employees.model.Role;
import com.glearning.employees.repository.EmployeeRepository;
import com.glearning.employees.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
	
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository=roleRepository;
	}
	
	public Role saveRole(Role role) {
		return this.roleRepository.save(role);
	}
	
	public Set<Role> fetchAllRoles(){
		return new HashSet<>(this.roleRepository.findAll());
	}
}
