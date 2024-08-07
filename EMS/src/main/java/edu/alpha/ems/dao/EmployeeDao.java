package edu.alpha.ems.dao;

import java.util.List;

import edu.alpha.ems.entity.Employee;

public interface EmployeeDao {

	Employee saveEmployee(Employee employee);

	Employee findEmployeeById(int employeeId);

	Employee updateEmployee(Employee employee);

	List<Employee> findAll();

	boolean deleteEmployee(int employeeId);
}
