package edu.alpha.ems.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import edu.alpha.ems.dao.DepartmentDao;
import edu.alpha.ems.entity.Department;
import edu.alpha.ems.exception.DepartmentNotFoundException;
import edu.alpha.ems.util.EntityManagerUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public Department saveDepartment(Department department) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(department);
		entityTransaction.commit();
		return department;
	}

	@Override
	public Department findDepartmentById(int departmentId) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		Department department = entityManager.find(Department.class, departmentId);
		return department;
	}

	@Override
	public Department updateDepartment(Department department) {
		if (department.getDepartmentId() != 0) {
			Department exstingDepartment = findDepartmentById(department.getDepartmentId());
			if (exstingDepartment != null) {
				EntityManager entityManager = EntityManagerUtil.getEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.merge(department);
				entityTransaction.commit();
				return department;
			}
			throw new DepartmentNotFoundException("Department With the Given Id = " + department.getDepartmentId()
					+ " Is Not Present So we can't Update the Department Info");
		}
		throw new DepartmentNotFoundException("Department With the Given Id = " + department.getDepartmentId()
				+ " Is Not Present So we can't Update the Department Info");
	}

	@Override
	public List<Department> findAll() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		String jpqlQuery = "SELECT d FROM Department d";
		Query query = entityManager.createQuery(jpqlQuery);

		@SuppressWarnings("unchecked")
		List<Department> listOfDepartment = (List<Department>) query.getResultList();
		return listOfDepartment;
	}

	@Override
	public boolean deleteById(int departmentId) {
		Department department = findDepartmentById(departmentId);
		if (department != null) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(department);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
