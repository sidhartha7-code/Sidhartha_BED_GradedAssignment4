package com.glearning.employees.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.employees.model.Employee;
import com.glearning.employees.model.Role;
import com.glearning.employees.model.User;
import com.glearning.employees.repository.EmployeeRepository;
import com.glearning.employees.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	@Autowired
	public BootstrapAppData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder; // And this
	}

	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		/*
		 * Employee ramesh=new Employee(); ramesh.setFirstName("Ramesh");
		 * ramesh.setEmail("ramesh@gmail.com"); this.employeeRepository.save(ramesh);
		 * 
		 * Employee suresh=new Employee(); suresh.setFirstName("Suresh");
		 * suresh.setEmail("suresh@gmail.com"); this.employeeRepository.save(suresh);
		 * 
		 * User vinay=new User(); vinay.setUsername("vinay");
		 * vinay.setPassword(this.passwordEncoder.encode("welcome"));
		 * //vinay.setEmailAddress("vinay@gmail.com");
		 * 
		 * 
		 * Role kiranRole=new Role(); kiranRole.setName("USER");
		 * 
		 * Role vinayRole=new Role(); vinayRole.setName("ADMIN");
		 * 
		 * // vinayRole.setUser(vinay);
		 * 
		 * // vinay.addRole(vinayRole);
		 * 
		 * User kiran=new User(); kiran.setUsername("kiran");
		 * kiran.setPassword(this.passwordEncoder.encode("welcome"));
		 * //kiran.setEmailAddress("kiran@gmail.com");
		 * 
		 * kiranRole.setUser(kiran);
		 * 
		 * kiran.addRole(kiranRole);
		 * 
		 * 
		 * this.userRepository.save(kiran); this.userRepository.save(vinay);
		 */

	}
}
