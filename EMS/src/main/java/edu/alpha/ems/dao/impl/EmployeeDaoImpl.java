package edu.alpha.ems.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import edu.alpha.ems.dao.EmployeeDao;
import edu.alpha.ems.entity.Employee;
import edu.alpha.ems.exception.EmployeeNotFoundException;
import edu.alpha.ems.util.EntityManagerUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee saveEmployee(Employee employee) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if (employee.getEmaployeeId() != 0) {
			Employee exstingEmployee = findEmployeeById(employee.getEmaployeeId());
			if (exstingEmployee != null) {
				EntityManager entityManager = EntityManagerUtil.getEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.merge(employee);
				entityTransaction.commit();
			}
			throw new EmployeeNotFoundException("Employee With the Given Id = " + employee.getEmaployeeId()
					+ " Is Not Present So we can't Update the Employee Info");
		}
		throw new EmployeeNotFoundException("Employee With the Given Id = " + employee.getEmaployeeId()
				+ " Is Not Present So we can't Update the Employee Info");
	}

	@Override
	public List<Employee> findAll() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		String jpqlQuery = "SELECT e FROM Employee e";
		Query query = entityManager.createQuery(jpqlQuery);

		@SuppressWarnings("unchecked")
		List<Employee> listOfEmployee = (List<Employee>) query.getResultList();
		return listOfEmployee;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Employee employee = findEmployeeById(employeeId);
		if (employee != null) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
