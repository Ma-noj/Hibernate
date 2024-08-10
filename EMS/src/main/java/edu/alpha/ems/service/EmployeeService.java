package edu.alpha.ems.service;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import edu.alpha.ems.dao.EmployeeDao;
import edu.alpha.ems.dao.impl.EmployeeDaoImpl;
import edu.alpha.ems.entity.Address;
import edu.alpha.ems.entity.Employee;
import edu.alpha.ems.exception.EmployeeNotFoundException;

public class EmployeeService {

	public static void employeeService(Scanner read) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		boolean flag = true;
		while (flag) {
			System.out.println("Selcet the Choice :- ");
			System.out.println("1.Add Employee\n2.Update Employee\n3.Display All"
					+ "\n4.Display By Id\n5.Update Address\n6.Delete Employee\n7.Main Menu");
			int choice = read.nextInt();
			switch (choice) {
			case 1:
				createEmployee(read, employeeDao);
				break;
			case 2:
				modifyEmployee(read, employeeDao);
				break;
			case 3:
				findaAll(employeeDao);
				break;
			case 4:
				findById(read, employeeDao);
				break;
			case 5:
				modifyAddress(read, employeeDao);
				break;
			case 6:
				deleteById(read, employeeDao);
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Select the Correct Choice!!");
				break;
			}
		}
	}

	public static void modifyAddress(Scanner read, EmployeeDao employeeDao) {
		System.out.println("Enter the Employee Id");
		int employeeId = read.nextInt();
		Employee employee = employeeDao.findEmployeeById(employeeId);
		if (Objects.nonNull(employee)) {
			Address address = employee.getAddress();
			read.nextLine();
			System.out.println("Enter the Street");
			address.setStreet(read.nextLine());
			System.out.println("Enter the City");
			address.setCity(read.nextLine());
			System.out.println("Enter the State");
			address.setState(read.nextLine());
			System.out.println("Enter the Country");
			address.setCountry(read.nextLine());
			System.out.println("Enter the Pincode");
			address.setPincode(read.nextInt());

			Employee updatedEmployee = employeeDao.updateEmployee(employee);
			address = updatedEmployee.getAddress();
			System.out.println("Updated Address info :- ");
			display(address);
		}
	}

	public static void deleteById(Scanner read, EmployeeDao employeeDao) {
		System.out.println("Enter the Employee Id");
		int employeeId = read.nextInt();
		if (employeeDao.deleteEmployee(employeeId)) {
			System.out.println("Employee Deleted");
		} else {
			System.err.println("Employee With the Given Id" + employeeId + " Not Found");
		}
	}

	public static void findById(Scanner read, EmployeeDao employeeDao) {
		System.out.println("Enter the Employee Id");
		int employeeId = read.nextInt();
		Employee employee = employeeDao.findEmployeeById(employeeId);
		if (Objects.nonNull(employee)) {
			display(employee);
		} else {
			System.err.println("Employee WIth the Given Id = " + employeeId + " Is Not Present");
		}
	}

	public static void modifyEmployee(Scanner read, EmployeeDao employeeDao) {
		System.out.println("Enter the Employee Id");
		int employeeId = read.nextInt();
		Employee employee = employeeDao.findEmployeeById(employeeId);
		if (Objects.nonNull(employee)) {
			System.out.println("Enter the Password :-");
			employee.setPassword(read.next());
			Employee updatedEmployee = employeeDao.updateEmployee(employee);
			System.out.println("Updated Employee Info");
			display(updatedEmployee);
		} else {
			throw new EmployeeNotFoundException("Employee with the Given Id = " + employeeId + " Is Not Present");
		}

	}

	public static void findaAll(EmployeeDao employeeDao) {
		List<Employee> listOfEmployee = employeeDao.findAll();
		for (int index = 0; index < listOfEmployee.size(); index++) {
			Employee employee = listOfEmployee.get(index);
			display(employee);
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
		System.out.println();
	}

	public static void display(Address address) {
		System.out.println(address);
		System.out.println();
	}

}
