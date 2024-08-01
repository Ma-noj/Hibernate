package edu.alpha.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.alpha.entity.Student;

public class FindAllStudentController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpqlQuery = "SELECT s FROM Student s";

		Query query = entityManager.createQuery(jpqlQuery);
		List listofStudent = query.getResultList();
		for (Object object : listofStudent) {
			Student student = (Student) object;
			System.out.println("Stduent id = " + student.getId());
			System.out.println("Stduent Name = " + student.getName());
			System.out.println("Stduent Age = " + student.getAge());
			System.out.println();
		}
	}

}
