package com.silver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.silver.entity.Employee;
import com.silver.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
	EmployeeRepository employeeRepository;
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	public List<Employee> insertEmployees(List<Employee>employees){
		return employeeRepository.saveAllAndFlush(employees) ;
		
	}
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	public Employee getEmployeeByID(int id) {
		return employeeRepository.findById(id).orElse(null);
		
	}
	public Employee updateEmployee(Employee employee) {
		Employee e=employeeRepository.findById(employee.getId()).orElse(null);
		e.setName(employee.getName());
		e.setSalary(employee.getSalary());
		return employeeRepository.save(e);
	}
	public String deleteEmployee(int id) {
	employeeRepository.deleteById(id);
	return "Employee record deleted";
		
	}
	
    public List<Employee> getEmployeesWithSalaryGreaterThanEqual10000() {
        return employeeRepository.findEmployeesWithSalaryGreaterThanEqual10000();
    }

	
	
	
}
