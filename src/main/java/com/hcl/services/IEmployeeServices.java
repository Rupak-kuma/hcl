package com.hcl.services;

import java.sql.SQLException;
import java.util.List;

import com.hcl.beans.Employee;

import com.hcl.exception.UserDefinedException;



public interface IEmployeeServices {
	public  List<Employee> displayEmployee();
	public Employee  addEmployee(Employee emp) throws UserDefinedException, SQLException;
	public boolean deleteEmployee(int id) throws UserDefinedException, SQLException;
	public Employee searchById(int idr) throws UserDefinedException;
//public void updateEmployee(String name,int id);
public Employee updateEmployee(int id,Employee e) throws UserDefinedException, SQLException;
//public List<Employee> searchList(int idr);

}
