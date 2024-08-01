package edu.alpha.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.alpha.entity.Student;

public class StudentController {

	public static void main(String[] args) {
		// 101
		// Ram
		// 23

		Student student = new Student();
		student.setId(102);
		student.setName("Raj");
		student.setAge(23);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alpha");
		EntityManager em = emf.createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();

		// Save Student

		entityTransaction.begin();// To begin the Track of the Operation
		em.persist(student);
		entityTransaction.commit();// To commit the operation on the Student table

	}

}
