package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(long id, Employee e) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Employee","id", id));
		employee.setFirstName(e.getFirstName());
		employee.setLastName(e.getLastName());
		employee.setEmail(e.getEmail());
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(email);
	}

}
