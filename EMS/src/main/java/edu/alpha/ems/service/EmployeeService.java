package edu.alpha.ems.service;

import java.util.Scanner;

import edu.alpha.ems.dao.EmployeeDao;
import edu.alpha.ems.dao.impl.EmployeeDaoImpl;
import edu.alpha.ems.entity.Address;
import edu.alpha.ems.entity.Employee;

public class EmployeeService {

	public static void employeeService(Scanner read) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		while (true) {
			System.out.println("Selcet the Choice :- ");
			System.out.println("1.Add Employee\n2.Update Employee\n3.Display All"
					+ "\n4.Display By Id\n5.Update Address\n6.Delete Employee\n7.Main Menu");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				createEmployee(read, employeeDao);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("Select the Correct Choice!!");
				break;
			}
		}
	}

	// Read the Employee Details and save to the DataBase
	public static void createEmployee(Scanner read, EmployeeDao employeeDao) {
		Employee employee = new Employee();
		read.nextLine();
		System.out.println("Enter the Employee Name:-");
		employee.setEmployeeName(read.nextLine());
		System.out.println("Enter the Employee Email:-");
		String employeeEmail = read.next();
		employee.setEmployeeEmail(employeeEmail);
		System.out.println("Enter the Password");
		String password = read.next();
		employee.setPassword(password);
		read.nextLine();
		System.out.println("Enter the Designation");
		String designation = read.nextLine();
		employee.setDesignation(designation);
		Address address = new Address();
		System.out.println("Enter the Employee Address Info");
		System.out.println("Enter the Street");
		String street = read.nextLine();
		address.setStreet(street);
		System.out.println("Enter the City");
		String city = read.nextLine();
		address.setCity(city);
		System.out.println("Enter the State");
		String state = read.nextLine();
		address.setState(state);
		System.out.println("Enter the Country");
		String country = read.nextLine();
		address.setCountry(country);
		System.out.println("Enter the Pincode");
		int pincode = read.nextInt();
		address.setPincode(pincode);
		employee.setAddress(address);
		Employee savedEmployee = employeeDao.saveEmployee(employee);
		display(savedEmployee);

	}

	public static void display(Employee employee) {
		System.out.println(employee);
	}

}
