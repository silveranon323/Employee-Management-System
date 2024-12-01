package com.silver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.silver.entity.Employee;
import com.silver.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/insertEmployee")
	public String insert(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
		return "Record inserted successfully";
	}
	@PostMapping("/insertEmployees")
	public List<Employee> inserts(@RequestBody List<Employee>employees){
		return employeeService.insertEmployees(employees);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees(){
		return employeeService.getEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findAllEmployeeById(@PathVariable int id) {	
		return employeeService.getEmployeeByID(id);
	}
	
	@PutMapping("/update")
	
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	
	@DeleteMapping("/delete/{id}")
	
	public String deleteEmployee(@PathVariable int id ) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/customQuery")
	public List<Employee> myCustomSqlQuery(){ 
		return employeeService.getEmployeesWithSalaryGreaterThanEqual10000();
	}
	
}
