package com.abcbank.service;

import com.abcbank.dao.EmployeeDAOImpl;
import com.abcbank.dao.IEmployeeDAO;
import com.abcbank.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public boolean registerEmployee(Employee employee) {
		boolean isDataValid = false; 
		boolean status = false; 
		if(employee.getName() != null){
			isDataValid = true;
		}
		
		if(isDataValid){
			status = employeeDAO.registerEmployee(employee);
		}
	
		return status;
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
