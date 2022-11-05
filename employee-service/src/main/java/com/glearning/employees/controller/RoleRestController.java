package com.glearning.employees.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employees.model.Role;
import com.glearning.employees.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleRestController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public Role saveRole(@RequestBody Role role) {
		return this.roleService.saveRole(role);
	}
	
	@GetMapping
	public Set<Role> fetchAllRoles() {
		return this.roleService.fetchAllRoles();
	}
}
