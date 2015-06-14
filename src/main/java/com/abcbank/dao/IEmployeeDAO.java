package com.abcbank.dao;

import com.abcbank.model.Employee;

public interface IEmployeeDAO {
	public boolean registerEmployee(Employee employee) ;

	public boolean updateEmployee(Employee employee);

	public boolean removeEmployee(Employee employee);
}
