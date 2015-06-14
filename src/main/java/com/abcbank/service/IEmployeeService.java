package com.abcbank.service;

import com.abcbank.model.Employee;

public interface IEmployeeService {

	public boolean registerEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee);
	
	public boolean removeEmployee(Employee employee);
}
