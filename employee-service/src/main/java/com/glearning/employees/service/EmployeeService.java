package com.glearning.employees.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.glearning.employees.model.Employee;
import com.glearning.employees.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	public Set<Employee> fetchAllEmployees(){
		return new HashSet<>(this.employeeRepository.findAll());
	}
	
	public Employee fetchEmployeeById(long empId) {
		return this.employeeRepository.findById(empId).orElseThrow();
	}
	
	public void deleteEmployeeById(long empId) {
		 this.employeeRepository.deleteById(empId);
	}
	
	public Set<Employee> fetchEmployeesbyFirstName(String firstname){
		
		return new HashSet<>(this.employeeRepository.findByfirstName(firstname));
	}
	
	public List<Employee> fetchEmployeesByOrderAsc(){
		return this.employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}
	
	
	public List<Employee> fetchEmployeesByOrderDesc(){
		return this.employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
	}
	
}
