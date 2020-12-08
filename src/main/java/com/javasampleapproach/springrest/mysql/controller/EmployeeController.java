package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Employee;
import com.javasampleapproach.springrest.mysql.repo.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		System.out.println("Get all Employee...");

		List<Employee> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}

	@PostMapping(value = "/employee/create")
	public ResponseEntity<String> postEmployee(@RequestBody Employee customer) {

		Employee _customer = repository.save(customer);
		return new ResponseEntity<>("Registration successful", HttpStatus.OK);
	}

}
