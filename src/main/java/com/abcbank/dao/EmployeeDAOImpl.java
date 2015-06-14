package com.abcbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abcbank.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

	public Connection createConnection() throws ClassNotFoundException,
			SQLException {
		System.out.println("Loading the driver in the memory");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded successfully");

		System.out
				.println("Trying to eshtablish database connection................");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/abcbank", "root", "root");
		System.out.println("Connection Eshtablished successfully........");
		return connection;
	}

	public boolean registerEmployee(Employee employee) {
		Connection connection;
		boolean status = false;
		try {
			connection = createConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into employee values(?,?,?,?)");
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setInt(4, employee.getSalary());
			
			System.out.println("Executing insert query......");
			int numberOfRowsUpdated = preparedStatement.executeUpdate();
			if(numberOfRowsUpdated == 1){
				status = true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new AbcBankException("Unable to connect to database...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new AbcBankException("Issue with Database Query");
		}
		
		
		return status;
	}

	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection;
		try {
			connection = createConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection;
		try {
			connection = createConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
