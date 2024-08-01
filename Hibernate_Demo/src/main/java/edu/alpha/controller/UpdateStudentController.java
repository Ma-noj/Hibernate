package edu.alpha.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.alpha.entity.Student;

public class UpdateStudentController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student = entityManager.find(Student.class, 102);
		if (student != null) {
			student.setAge(34);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();

			Student updatedStudent = entityManager.find(Student.class, 102);
			System.out.println("Student Id = " + updatedStudent.getId());
			System.out.println("Student Age = " + updatedStudent.getAge());
		} else {
			System.out.println("Student Does not Present with the Give Id ");
		}
	}

}
