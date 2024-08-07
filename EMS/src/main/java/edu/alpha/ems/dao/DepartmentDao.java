package edu.alpha.ems.dao;

import java.util.List;

import edu.alpha.ems.entity.Department;

public interface DepartmentDao {
	Department saveDepartment(Department department);

	Department findDepartmentById(int departmentId);

	Department updateDepartment(Department department);

	List<Department> findAll();

	boolean deleteById(int departmentId);
}
