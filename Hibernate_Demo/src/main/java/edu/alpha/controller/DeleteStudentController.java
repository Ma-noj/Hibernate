package edu.alpha.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.alpha.entity.Student;

public class DeleteStudentController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = entityManager.find(Student.class, 102);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			System.out.println("Student with the Give id Removed");
		} else {
			System.out.println("Student with the Give id Not Present");
		}
	}

}
