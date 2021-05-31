package com.hcl.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beans.Employee;

import com.hcl.exception.UserDefinedException;
import com.hcl.services.IEmployeeServices;
@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class EmployeeController {

	
	@Autowired
	private IEmployeeServices service;
	
	

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> displayEmployee() {
		//List<Employee> list = service.displayEmployee();
			
		return new ResponseEntity<List<Employee>>(service.displayEmployee(),HttpStatus.OK);
	}
	


		@PostMapping("/employees")
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) throws UserDefinedException, SQLException {
			return new ResponseEntity<Employee>(service.addEmployee(emp),HttpStatus.OK);
			
			
		
	}
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee>  searchEmployee(@PathVariable int id) throws UserDefinedException{
			//List<Employee> l = new ArrayList<Employee>();
			return new ResponseEntity<Employee>(service.searchById(id),HttpStatus.OK);
		
			
		}
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee e) throws UserDefinedException, SQLException  {
			return new ResponseEntity<Employee>(service.updateEmployee(id,e),HttpStatus.OK);
		}
		
		
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws UserDefinedException, SQLException {
			return new ResponseEntity<Boolean>(service.deleteEmployee(id),HttpStatus.OK);
	}
	}