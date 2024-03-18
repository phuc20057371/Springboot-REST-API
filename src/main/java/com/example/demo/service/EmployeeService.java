package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee e);
	List<Employee> getAllEmployees();
	Employee findEmployeeById(long id);
	Employee updateEmployee(long id, Employee e);
	void deleteEmployee(long id);
	List<Employee> findByEmail(String email);
}
