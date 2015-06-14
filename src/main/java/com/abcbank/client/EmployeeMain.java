package com.abcbank.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.abcbank.model.Employee;
import com.abcbank.service.EmployeeServiceImpl;
import com.abcbank.service.IEmployeeService;

public class EmployeeMain {
	
	static IEmployeeService employeeService = new EmployeeServiceImpl();

	public static void main(String args[]) {
		int employeeId;
		String name = null; 
		String address = null;
		int salary;
		while(true){			
			try {
				System.out.println("1. Register a new Employee");
				System.out.println("2. Update an existing Employee");
				System.out.println("3. Remove an existing Employee");
				System.out.println("4. List All Empoloyees");
				System.out.println("5. Search Employee(s)");
				System.out.println("6. Exit");
				
				System.out.println("\nEnter your choice in (1,2,3,4,5,6): ");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int userChoice = Integer.parseInt(br.readLine());
				if(userChoice == 6){
					System.out.println("Thanks for using ABC Bank Portal!!!");
					break;
				}else if(userChoice < 1 || userChoice > 6){
					System.out.println("Invalid User Selection. Please try again.");
					continue;
				}else if(userChoice == 1){
					System.out.println("Enter employee ID: ");
					employeeId = Integer.parseInt(br.readLine());

					System.out.println("Enter employee Name: ");
					name = br.readLine();
					
					System.out.println("Enter employee Address: ");
					address = br.readLine();
					
					System.out.println("Enter employee Salary: ");
					salary = Integer.parseInt(br.readLine());
					
					Employee employee = new Employee();
					employee.setEmployeeId(employeeId);
					employee.setName(name);
					employee.setAddress(address);
					employee.setSalary(salary);
					
					boolean status = employeeService.registerEmployee(employee);
					if(status){
						System.out.println("Record inserted Successfully");
					}else{
						System.out.println("Unable to insert record in the database");
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Please enter only numerics");
				continue;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
