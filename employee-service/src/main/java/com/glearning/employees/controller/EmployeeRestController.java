package com.glearning.employees.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employees.model.Employee;
import com.glearning.employees.model.Role;
import com.glearning.employees.service.EmployeeService;
import com.glearning.employees.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}
	
	@GetMapping
	public Set<Employee> fetchAllEmployees() {
		return this.employeeService.fetchAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") long empId) {
		return this.employeeService.fetchEmployeeById(empId);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") long empId) {
		 this.employeeService.deleteEmployeeById(empId);
		 return "Deleted employee id -"+empId;
	}
	
	@PutMapping
	public Employee updateEmployeeById(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}
	
	
	@GetMapping("/sort/asc")
	public List<Employee> fetchEmployeesByOrderAsc(){
		return this.employeeService.fetchEmployeesByOrderAsc();		
	}
	
	@GetMapping("/sort/desc")
	public List<Employee> fetchEmployeesByOrderDesc(){
		return this.employeeService.fetchEmployeesByOrderDesc();		
	}
	
	@GetMapping("/search/{firstname}")
	public Set<Employee> fetchEmployeesbyFirstName(@PathVariable("firstname") String firstName){
		return this.employeeService.fetchEmployeesbyFirstName(firstName);
	}
	
}
