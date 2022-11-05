package com.glearning.employees.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employees.model.Role;
import com.glearning.employees.model.User;
import com.glearning.employees.service.RoleService;
import com.glearning.employees.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
	
	@GetMapping
	public Set<User> fetchAllUsers() {
		return this.userService.fetchAllUsers();
	}

}
