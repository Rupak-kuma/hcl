package com.hcl.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Employee;

import com.hcl.exception.UserDefinedException;
import com.hcl.repository.EmployeeDAO;




@Service
public class ServicesEmployeeImpl implements IEmployeeServices{
	
@Autowired
private EmployeeDAO dao;



public Employee addEmployee(Employee emp) throws UserDefinedException {
	if(!dao.findById(emp.getId()).isPresent())

  return dao.save(emp);
	else 
		throw new UserDefinedException("not exist");
}
	
	public  List<Employee> displayEmployee(){
		//List<Employee> list = new ArrayList<Employee>();
		//list = dao.findAll();
		//List<Employee> l = list.stream().filter(i->i.getId()>5).collect(Collectors.toList());
		return dao.findAll();
		}
	
	
	public Employee searchById(int id) throws UserDefinedException {
		if(dao.findById(id).isPresent())
			return dao.findById(id).get();
		else
			throw new UserDefinedException("not exist");
	}
	

	public boolean deleteEmployee(int id) throws UserDefinedException,SQLException {
		// TODO Auto-generated method stub
		if(dao.findById(id).isPresent()) {
			dao.deleteById(id);
			return true;
		}
		
		else 
			throw new UserDefinedException("not exist");
		
	}
	public Employee updateEmployee(int id,Employee emp) throws UserDefinedException, SQLException {

		if(dao.findById(id).isPresent())
			return dao.saveAndFlush(emp);
		else
			throw new UserDefinedException("not exist");
	}

	

	
}