package com.mybootapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Employee;
import com.mybootapp.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmployeeController {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@PostMapping("/employee/insert")
	public Employee insertEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
//		System.out.println(employee);
		
	}
	
	@GetMapping("/employee/all")
	public List<Employee> getAllEmployee(){
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@GetMapping("/employee/one/{id}")
	public Employee getSingleEmployee(@PathVariable("id") Long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		
		if(!optional.isPresent())
			throw new RuntimeException("ID is Invalid");
		
		Employee e = optional.get();
		return e;
		
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public void deleteEmployeeById(@PathVariable("id") Long id) {
		employeeRepository.deleteById(id);
	}
	
	@PutMapping("/employee/update/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id,
									@RequestBody Employee newEmployee) {
										
		Optional<Employee> optional = employeeRepository.findById(id);
		
		if(!optional.isPresent())
			throw new RuntimeException("Id is Invalid");
		
		Employee oldEmployee = optional.get();
		
		oldEmployee.setName(newEmployee.getName());
		oldEmployee.setSalary(newEmployee.getSalary());
		oldEmployee.setCity(newEmployee.getCity());
		
		
		return employeeRepository.save(oldEmployee);
		
		
	}

}
